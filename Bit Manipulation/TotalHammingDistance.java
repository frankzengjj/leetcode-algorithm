class Solution {
    public int totalHammingDistance(int[] nums) {
        int mask = 1, res = 0;
        for (int i=0; i<31; i++) {
            int count = 0;
            for (int num: nums) {
                if ((num & mask) != 0) count++;
            }
            res += (nums.length - count) * count;
            mask <<= 1;
        }
        return res;
    }
}