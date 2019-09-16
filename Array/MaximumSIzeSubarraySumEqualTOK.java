class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> prefix = new HashMap<>();
        int res = 0, sum = 0;
        prefix.put(0, -1);
        
        
        /*
        prefix[j] - prefix[i] == k where i < j
        prefix[i] == prefix[j] - k
        */
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            if (!prefix.containsKey(sum)) prefix.put(sum, i);
            if (prefix.containsKey(sum-k)) res = Math.max(res, i-prefix.get(sum-k));
        }
        return res;
    }
}
