class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums.length==0) return 0;
        Map<Integer, Integer> sums = new HashMap<>();
        sums.put(0,1);
        int count = 0, prefixSum = 0;
        for (int i=0; i<nums.length; i++) {
            prefixSum += nums[i];
            if (sums.containsKey(prefixSum-k)) {
                count += sums.get(prefixSum-k);
            }
            sums.put(prefixSum, sums.getOrDefault(prefixSum, 0)+1);
        }
        return count;
    }
}