class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        boolean[] used=new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(res, combination, 0, nums, used);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> combination, 
                           int pos, int[] nums, boolean[] used) {
        if(pos==nums.length) {
            res.add(new ArrayList<Integer>(combination));
            return;
        }
        
        for(int i=0; i<nums.length; i++) {
            if(used[i]) continue;
            if(i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;
            combination.add(nums[i]);
            used[i]=true;
            backtrack(res, combination, pos+1, nums, used);
            combination.remove(combination.size()-1);
            used[i]=false;
        }
    }
}