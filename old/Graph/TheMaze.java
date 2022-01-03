class Solution {
    private int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public boolean hasPath(int[][] m, int[] start, int[] destination) {
        if (m.length == 0) return false;
        return dfs(m, start, destination, new boolean[m.length][m[0].length]);
    }
    
    private boolean dfs(int[][] m, int[] curPos, int[] dest, boolean[][] visited) {
        if (curPos[0] == dest[0] && curPos[1] == dest[1]) return true;
        int r = curPos[0], c = curPos[1];
        if (r<0 || c<0 || r>=m.length || c>=m[0].length || visited[r][c]) return false;
        visited[curPos[0]][curPos[1]] = true;
        for (int[] dir: dirs) {
            int row = r, col = c;
            while (row >= 0 && col >= 0 && row < m.length && col < m[0].length && m[row][col] == 0) {
                row += dir[0];
                col += dir[1];
            }
            if (dfs(m, new int[]{row-dir[0], col-dir[1]}, dest, visited)) {
                return true;
            }
        }
        return false;
    }
}