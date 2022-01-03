class NumArray {

    private int[] prefix;
    public NumArray(int[] nums) {
        prefix = new int[nums.length];
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            prefix[i] = sum;
        }
        System.out.println(Arrays.toString(prefix));
    }
    
    public int sumRange(int i, int j) {
        return i==0 ? prefix[j] : prefix[j] - prefix[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */