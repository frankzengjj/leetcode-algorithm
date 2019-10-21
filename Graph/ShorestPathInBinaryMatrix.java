class Solution {
    class Point {
        int x;
        int y;
        int dist;
        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    private int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,-1}, {-1, 1}, {1,-1}, {1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;
        if (grid[0][0] == 1 || grid[N-1][N-1] == 1) return -1;
        if (N==1) return 1;
        Queue<Point> q = new ArrayDeque<>();
        //boolean[][] visited = new boolean[N][N];
        q.add(new Point(0, 0, 1));
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                Point cur = q.poll();
                for (int[] dir: dirs) {
                    int r = cur.x + dir[0];
                    int c = cur.y + dir[1];
                    if (r<0 || c<0 || r>=N || c>=N || grid[r][c] == 1) {
                        continue;
                    }
                    if (r==N-1 && c==N-1) {
                        return cur.dist+1;
                    }
                    Point nei = new Point(r, c, cur.dist+1);
                    grid[r][c] = 1;
                    q.add(nei);
                }
            }
        }
        return -1;
    }
}