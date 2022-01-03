class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0, res = nums.length+1, sum = 0;
        while (right < nums.length) {
            if (sum < s) {
                sum += nums[right++];    
            }
            if (sum >= s) {
                while (sum >= s) {
                    res = Math.min(res, right-left);
                    sum -= nums[left++];
                }
            }
        }
        return res==nums.length+1 ? 0 : res;
    }
}
