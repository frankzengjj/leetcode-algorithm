class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        int m = matrix.length, n = matrix[0].length;
        
        boolean[][] p = new boolean[m][n];
        boolean[][] a = new boolean[m][n];
        
        for (int i=0; i<m; i++) {
            dfs(matrix, p, i, 0, -1);
            dfs(matrix, a, i, n-1, -1);
        }
        
        for (int j=0; j<n; j++) {
            dfs(matrix, p, 0, j, -1);
            dfs(matrix, a, m-1, j, -1);
        }
        
        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
                if (p[r][c] && a[r][c]) {
                    res.add(new ArrayList<>(Arrays.asList(r, c)));
                }
            }
        }
        return res;
    }
    
    private void dfs(int[][] m, boolean[][] visited, int row, int col, int h) {
        if (row < 0 || col < 0 || row >= m.length || col >= m[0].length) return;
        if (visited[row][col] || m[row][col] < h) return;
        visited[row][col] = true;
        dfs(m, visited, row+1, col, m[row][col]);
        dfs(m, visited, row-1, col, m[row][col]);
        dfs(m, visited, row, col+1, m[row][col]);
        dfs(m, visited, row, col-1, m[row][col]);
    }
}