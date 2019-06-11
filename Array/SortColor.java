import java.util.*;
class Solution {
    public void sortColors(int[] nums) {
        int zero=-1; // nums[0...zero]==0
        int two=nums.length; // nums[two...n-1]==2
        for(int i=0; i<two;) {
            if(nums[i]==1) {
                i++;
            } else if(nums[i]==2) {
                two--;
                swap(nums, two, i);
            } else {
                zero++;
                swap(nums, zero, i);
                i++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}