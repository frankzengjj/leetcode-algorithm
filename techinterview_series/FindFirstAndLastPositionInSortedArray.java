class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = search(nums, 0, nums.length - 1, target, true);
        int last = search(nums, 0, nums.length - 1, target, false);
        return new int[]{first, last};
    }
    
    private int search(int[] nums, int lo, int hi, int target, boolean findFirst) {   
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (findFirst) {
                if ((mid == 0 || nums[mid - 1] < target) && nums[mid] == target) {
                    return mid;
                } else {
                    if (target > nums[mid]) {
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }
            } else {
                if ((mid == nums.length-1 || nums[mid + 1] > target) && nums[mid] == target) {
                    return mid;
                } else {
                    if (target < nums[mid]) {
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
}