class Solution {
    public int removeElement(int[] nums, int val) {
        // 3 2 2 3
        int i=0;
        for(int j=0; j<nums.length; j++) {
            if(nums[j]!=val) {
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
    }
}