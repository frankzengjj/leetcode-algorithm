class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max=Integer.MIN_VALUE;
        dp[0]=nums[0];
        
        for(int i=1; i<nums.length; i++) {
            dp[i]=Math.max(dp[i-1]+nums[i], nums[i]);
        }
        
        for(int i=0; i<dp.length; i++) {
            max=Math.max(dp[i], max);
        }
        return max;
        
    }
}