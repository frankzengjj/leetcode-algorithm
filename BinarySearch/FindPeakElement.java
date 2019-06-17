class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        int l=0, r=nums.length-1;
        if((r==nums.length-1 && nums[r]>nums[r-1])) {
            return r;
        } else if((l==0 && nums[l]>nums[l+1])) {
            return l;
        }
        while(l<r) {
            int mid=l+(r-l)/2;
             if (nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1]) {
                return mid;
            } else if(nums[mid-1] < nums[mid] && nums[mid] < nums[mid+1]) {
                l=mid+1;
            } else {
                r=mid;
            }
        }
        return -1;
    }

    // Official solution
    public int findPeakElement2(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}