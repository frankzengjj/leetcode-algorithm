class Solution {
    public int res = 0;
    public int empty = 1;
    public int uniquePathsIII(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int[] end = new int[2];
        int r = 0, c = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    end[0] = i;
                    end[1] = j;
                }
                if (grid[i][j] == 1) {
                    r = i;
                    c = j;
                }
                if (grid[i][j] == 0) {
                    empty++;
                }
            }
        }
        
        dfs(r, c, grid, end);
        return res;
    }
    private void dfs(int r, int c, int[][] grid, int[] end) {
        if (r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c] < 0) {
            return;
        }
        if (r==end[0] && c==end[1]) {
            if (empty == 0) {
                res++;
            }
            return;
        }
        
        empty--;
        grid[r][c] = -2;
        dfs(r+1, c, grid, end);
        dfs(r-1, c, grid, end);
        dfs(r, c+1, grid, end);
        dfs(r, c-1, grid, end);
        grid[r][c] = 0;
        empty++;
    }
}
