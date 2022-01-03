class Solution {
    public int[][] dirs = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public Integer res = 0;
    public int orangesRotting(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    dfs(grid, i, j, visited);
                }
            }
        }
        return res;
    }
    
    private void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;
        if (visited[i][j] || grid[i][j] == 0) return;
        if (!visited[i][j]) res++;
        grid[i][j] = 2;
        visited[i][j] = true;
        for (int[] dir: dirs) {
            dfs(grid, i+dir[0], j+dir[1], visited);
        }
    }
    
    
}