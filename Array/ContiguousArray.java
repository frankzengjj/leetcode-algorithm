class Solution {
    public int findMaxLength(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return 0;
        int res = 0, diff = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i=0; i<nums.length; i++) {
            diff += nums[i] == 0 ? -1 : 1;
            if (!map.containsKey(diff))  {
                map.put(diff, i);
            } else {
                res = Math.max(res, i-map.get(diff));
            }
        }
        return res;
    }
}
