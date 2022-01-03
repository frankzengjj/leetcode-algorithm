class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] toLeft=new int[nums.length], toRight=new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            if(i==0) {
                toLeft[i]=1;
            } else {
                toLeft[i]=toLeft[i-1]*nums[i-1];
            }
        }
        
        for(int j=nums.length-1; j>=0; j--) {
            if(j==nums.length-1) {
                toRight[j]=1;
            } else {
                toRight[j]=toRight[j+1]*nums[j+1];
            }
        }
        
        for(int k=0; k<nums.length; k++) {
            nums[k]=toLeft[k]*toRight[k];
        }
        return nums;
    }
}