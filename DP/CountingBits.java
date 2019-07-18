class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        if(num==0) return dp;
        dp[0]=0;
        dp[1]=1;
        for(int i=2; i<dp.length; i++) {
           if((i&(i-1))==0) {
               dp[i]=1;
           } else if(i%2!=0) {
               dp[i]=dp[i-1]+1;
           } else{
               dp[i]=dp[i/2];
           }
        }
        return dp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countBits(6));
    }
}