class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, new ArrayList<Integer>(), res, 0);
        return res;
    }
    
    private void helper(int[] nums, List<Integer> subset, List<List<Integer>> res, int start) {
        res.add(new ArrayList<>(subset));
        for(int i=start; i<nums.length; i++) {
            if(i>start && nums[i]==nums[i-1]) continue;
            subset.add(nums[i]);
            helper(nums, subset, res, i+1);
            subset.remove(subset.size()-1);
        }
    }
}