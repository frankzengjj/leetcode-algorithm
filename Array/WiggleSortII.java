class Solution {
    public void wiggleSort(int[] nums) {
        // 1 1 1 4 5 6
        Arrays.sort(nums);
        int n=nums.length, k=(n-1)/2, j=n-1;
        int[] res = new int[nums.length];
        if(n%2!=0) res[n-1]=nums[0];
        for(int i=0; i<n-1;) {
            res[i]=nums[k--];
            res[i+1]=nums[j--];
            i+=2;
        }
        for(int i=0; i<n; i++) {
            nums[i]=res[i];
        }
    }
}