class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        int l=0, r=nums.length-1;
        while(l<=r) {
            int mid=l+(r-l)/2;
            if(nums[mid]==target) {
                return mid;
            }
            // 5 6 7 8 1 2 3
            if(nums[l]<=nums[mid]) {
                if(target<=nums[mid] && target>=nums[l]) {
                    r=mid-1;
                } else {
                    l=mid+1;
                }
            } else {
                if(target>=nums[mid] && target<=nums[r]) {
                    l=mid+1;
                } else {
                    r=mid-1;
                }
            }
        }
        return -1;
    }
}