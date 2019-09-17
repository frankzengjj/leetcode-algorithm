class Solution {
    private int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] memo = new int[m][n];
        int max = 1;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                int len = dfs(matrix, i, j, memo);
                max = Math.max(len, max);
            }
        }
        return max;
    }
    
    private int dfs(int[][] m, int r, int c, int[][] memo) {
        if (memo[r][c] != 0) return memo[r][c];
        
        int max = 1;
        for (int[] dir: dirs) {
            int row = r + dir[0], col = c + dir[1];
            if (row < 0 || col < 0 || row >= m.length || col >= m[0].length || m[row][col] <= m[r][c]) continue;
            int len = 1 + dfs(m, row, col, memo);
            max = Math.max(max, len);
        }
        memo[r][c] = max;
        return max;
    }
}