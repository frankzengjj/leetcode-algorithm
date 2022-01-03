class Solution {
    public void wallsAndGates(int[][] rooms) {
        int empty = Integer.MAX_VALUE;
        if (rooms.length == 0) return;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i=0; i<rooms.length; i++) {
            for (int j=0; j<rooms[0].length; j++) {
                if (rooms[i][j] == 0) q.add(new int[]{i, j});
            }
        }
        
        while (!q.isEmpty()) {
            int[] top = q.poll();
            int row = top[0], col = top[1];
            for (int[] dir: dirs) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r < 0 || c < 0 || r >= rooms.length || c >= rooms[0].length || rooms[r][c] != empty) {
                    continue;
                }
                rooms[r][c] = rooms[row][col] + 1;
                q.add(new int[]{r, c});
            }
        }
    }
}