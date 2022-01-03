class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        int max = 0;
        dp[0]=1;
        for (int i=1; i<nums.length; i++) {
            dp[i] = nums[i]>nums[i-1] ? dp[i-1]+1 : 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}