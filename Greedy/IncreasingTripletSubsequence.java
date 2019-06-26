class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3) return false;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            int curr = nums[i];
            if(curr > min2) {
                return true;
            } else if(curr < min1) {
                min1=curr;
            } else if(curr < min2 && curr > min1) {
                min2=curr;
            }
        }
        return false;
    }
}