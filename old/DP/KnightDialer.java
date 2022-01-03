class Solution {
    public int knightDialer(int N) {
        int mod = (int) Math.pow(10, 9) + 7;
        int[][] dirs = new int[][] {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, { }, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
        long[][] dp = new long[N][10];
        // initialization
        for (int i=0; i<10; i++) dp[0][i] = 1;
        
        // dp process
        for (int k=1; k<N; k++) {
            for (int i=0; i<10; i++) {
                int[] moves = dirs[i];
                for (int move: moves) {
                    dp[k][i] = (dp[k][i] + dp[k-1][move]) % mod;
                }
            }
        }
        
        // sum up the result
        long res = 0L;
        for (int i=0; i<10; i++) {
            res += dp[N-1][i];
            res %= mod;
        }
        return (int) res;
    }
}