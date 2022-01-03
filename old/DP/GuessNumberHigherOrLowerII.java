class Solution {
    public int getMoneyAmount(int n) {
        return dfs(1, n, new int[n+1][n+1]);
    }
    
    private int dfs(int a, int b, int[][] memo) {
        if (a>=b) return 0;
        if (memo[a][b]>0) {
            return memo[a][b];
        }
        
        int res = Integer.MAX_VALUE;
        for (int i=a; i<=b; i++) {
           res = Math.min(res, i + Math.max(dfs(a, i-1, memo), dfs(i+1, b, memo)));
        }
        memo[a][b] = res;
        return res;
    }
}