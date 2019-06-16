class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        res[0]=search(nums, target, false);
        if(res[0]!=-1) {
            res[1]=search(nums, target, true);
        }
        return res;
    }
    
    private int search(int[] nums, int target, boolean forward) {
        int l=0, r=nums.length-1, key=-1;
        while(l<=r) {
            int mid = l+(r-l)/2;
            if(target>nums[mid]) {
                l=mid+1;
            } else if(target<nums[mid]) {
                r=mid-1;
            } else {
                key=mid;
                if(forward) {
                    l=mid+1;
                } else {
                    r=mid-1;
                }
            }
        }
        return key;
    }
}