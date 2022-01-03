class Solution {
    public int removeDuplicates(int[] nums) {
        int insertPos=2;
        for(int i=2; i<nums.length; i++) {
            if(nums[i]>nums[insertPos-2]) {
                nums[insertPos++]=nums[i];
            }
        }
        return insertPos;
    }
}