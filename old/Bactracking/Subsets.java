class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, new ArrayList<Integer>(), res, 0);
        return res;
        
    }
    
    private void helper(int[] nums, List<Integer> subset, List<List<Integer>> res, int start) {
        res.add(new ArrayList<>(subset));
        for(int i=start; i<nums.length; i++) {
            subset.add(nums[i]);
            helper(nums, subset, res, i+1);
            subset.remove(subset.size()-1);
        }
    }
}