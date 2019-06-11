class Solution {
    public int search(int[] nums, int target) {
        // 4 5 6 7 0 1 2
        // 6 7 1 2 3 4 6
        if(nums.length==0) return -1;
        int l=0, r=nums.length-1;
        while(l+1<r) {
            int mid=l+(r-l)/2;
            if(nums[mid]==target) {
                return mid;
            }
            
            if(nums[l] < nums[mid]) {
                if(target<=nums[mid] && target>=nums[l]) {
                    r=mid;
                } else {
                    l=mid;
                }
            } else {
                if(target>=nums[mid] && target<=nums[r]) {
                    l=mid;
                } else {
                    r=mid;
                }
            }
        }
        if(nums[l]==target) return l;
        if(nums[r]==target) return r;
        return -1;
    }
}