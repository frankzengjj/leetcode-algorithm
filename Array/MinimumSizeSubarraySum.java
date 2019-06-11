class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int left=0, right=-1, minSize=nums.length+1, sum=0;
        while(left<nums.length) {
            if(right+1 < nums.length && sum<s) {
                sum+=nums[++right];
            } else {
                sum-=nums[left++];
            }
            
            if(sum>=s) {
                minSize=Math.min(minSize, right-left+1);
            }
        }
        return minSize==nums.length+1 ? 0 : minSize;
    }
}