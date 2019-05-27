class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        int[] arr = new int[2];
        for(int i=0; i<nums.length; i++) {
            if(mp.containsKey(target-nums[i])) {
                arr[0]=mp.get(target-nums[i]);
                arr[1]=i;
            } else {
                mp.put(nums[i],i);
            }
        }
        return arr;
    }
}