class Solution {
    public int numDistinctIslands(int[][] grid) {
        Set<String> shapes = new HashSet<>();
        int count = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder path = new StringBuilder();
                    dfs(grid, i, j, 0, 0, path);
                    if (shapes.add(path.toString())) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    
    private void dfs(int[][] grid, int row, int col, int m, int n, StringBuilder path) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != 1) {
            return;
        }
        path.append(m+" "+n);
        grid[row][col] = 0;
        dfs(grid, row+1, col, m+1, n, path);
        dfs(grid, row, col+1, m, n+1, path);
        dfs(grid, row-1, col, m-1, n, path);
        dfs(grid, row, col-1, m, n-1, path);
    }
}