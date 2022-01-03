class Solution {
    public int longestArithSeqLength(int[] A) {
        HashMap<Integer, Integer>[] dp = new HashMap[A.length];
        int res = 0;
        for (int i=0; i<A.length; i++) {
            dp[i] = new HashMap<>();
            for (int j=0; j<i; j++) {
                int diff = A[i] - A[j];
                dp[i].put(diff, dp[j].getOrDefault(diff, 1)+1);
                res = Math.max(res, dp[i].get(diff));
            }
        }
        return res;
    }
}