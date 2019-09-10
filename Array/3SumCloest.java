class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++) {
            int lo = i+1, hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi] + nums[i];
                if (sum > target) {
                    hi--;
                } else {
                    lo++;
                }
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
            }
        }
        return res;
    }
}