class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) return 0;
        int max = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    List<int[]> area = new ArrayList<>();
                    dfs(grid, i, j, area);
                    max = Math.max(area.size(), max);
                }
            }
        }
        return max;
    }
    
    private void dfs(int[][] g, int r, int c, List<int[]> area) {
        if (r < 0 || c < 0 || r >= g.length || c >= g[0].length || g[r][c] == 0) {
            return;
        }
        
        area.add(new int[]{r, c});
        g[r][c] = 0;
        dfs(g, r+1, c, area);
        dfs(g, r-1, c, area);
        dfs(g, r, c+1, area);
        dfs(g, r, c-1, area);
    }
}