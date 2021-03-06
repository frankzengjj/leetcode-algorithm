class Solution {
    public int[] twoSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int[] result = new int[2];
        int minDiff = Integer.MAX_VALUE;
        for (int lo = 0, hi = nums.length - 1; lo < hi; ) {
            int diff = target - (nums[lo] + nums[hi]);
            if (diff > 0) {
                if (diff < minDiff) {
                    minDiff = diff;
                    result[0] = nums[lo];
                    result[1] = nums[hi];
                }
                lo++;
            } else if (diff < 0) {
                hi--;
            } else {
                result[0] = nums[lo];
                result[1] = nums[hi];
                break;
            }
        }
        return result;
    }
}