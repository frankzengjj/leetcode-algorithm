import java.util.*;

class Solution {
    class Node {
        public int x;
        public int y;
        public int dist;

        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public int shortestDistance(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0,0));
        visited[0][0]=true;
        while (!q.isEmpty()) {
            Node top = q.poll();
            visited[top.x][top.y] = true;

            if (grid[top.x][top.y]==9) {
                return top.dist-1;
            }
            // down
            if (top.x+1 < grid.length &&
             grid[top.x+1][top.y] !=0 && 
             !visited[top.x+1][top.y]) {
                q.add(new Node(top.x+1, top.y, top.dist+1));
            }

            // up
            if (top.x-1 > 0 && 
            grid[top.x-1][top.y] !=0 && 
            !visited[top.x-1][top.y]) {
                q.add(new Node(top.x-1, top.y, top.dist+1));
            }

            // left
            if (top.y-1 > 0 && 
            grid[top.x][top.y-1] !=0 && 
            !visited[top.x][top.y-1]) {
                q.add(new Node(top.x, top.y-1, top.dist+1));
            }

            // right
            if (top.y+1 < grid[0].length &&
             grid[top.x][top.y+1] !=0 && 
             !visited[top.x][top.y+1]) {
                q.add(new Node(top.x, top.y+1, top.dist+1));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,1,0,1}, 
                                   {1,1,0,0},
                                   {0,1,1,1},
                                   {1,0,9,1}};
        System.out.println(new Solution().shortestDistance(grid));
    }
}