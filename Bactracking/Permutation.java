class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        backtrack(res, combination, 0, nums);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> combination, int pos, int[] nums) {
        if(pos==nums.length) {
            res.add(new ArrayList<Integer>(combination));
            return;
        }
        
        for(int i=0; i<nums.length; i++) {
            combination.add(nums[i]);
            backtrack(res, combination, pos+1, nums);
            combination.remove(combination.size()-1);
        }
    }
}