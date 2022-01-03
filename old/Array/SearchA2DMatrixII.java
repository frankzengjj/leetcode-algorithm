class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i=1; i<nums.length; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i]>nums[j]) {
                    dp[i]=Math.max(dp[j]+1, dp[i]);
                }
            }
        }
        int res=0;
        for(int k=0; k<nums.length; k++) {
            res=Math.max(res, dp[k]);
        }
        return res;
    }
}