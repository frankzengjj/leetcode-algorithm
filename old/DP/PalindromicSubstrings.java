class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        for (int i=0; i<s.length(); i++) {
            dp[i][i] = true;
            count++;
        }
        
        for (int start=s.length()-1; start>=0; start--) {
            for (int end=start+1; end<s.length(); end++) {
                if (s.charAt(start) == s.charAt(end)) {
                    if (end-start==1 || dp[start+1][end-1]) {
                        dp[start][end] = true;
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}