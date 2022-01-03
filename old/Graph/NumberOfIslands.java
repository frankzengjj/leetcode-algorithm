class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int m=grid.length, n=grid[0].length;
        int ans=0;
        for(int row=0; row<m; row++) {
            for(int col=0; col<n; col++) {
                if(grid[row][col]=='1') {
                    ans++;
                    dfs(grid, row, col, m, n);
                }
            }
        }
        return ans;
    }
    
    private void dfs(char[][] grid, int row, int col, int m, int n) {
        if(row<0 || col <0 || row>=m || col>=n || grid[row][col]=='0') {
            return;
        }
        grid[row][col]='0';
        dfs(grid, row+1, col, m, n);
        dfs(grid, row, col+1, m, n);
        dfs(grid, row-1, col, m, n);
        dfs(grid, row, col-1, m, n);
    }
}