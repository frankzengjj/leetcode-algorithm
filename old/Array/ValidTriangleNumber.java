class Solution {
    public int triangleNumber(int[] nums) {
        if (nums.length < 3) return 0;
        int res = 0;
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                for (int k=j+1; k<nums.length; k++) {
                    if (isTriangle(nums[i], nums[j], nums[k])) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
    private boolean isTriangle(int a, int b, int c) {
        return a+b > c && a+c > b && b+c > a;
    }
}