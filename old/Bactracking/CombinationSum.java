class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }
    
    private void backtrack(int[] candidates, int target, int level, List<Integer> cur, List<List<Integer>> res) {
        if(target==0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        for(int i=level; i<candidates.length; i++) {
            if(candidates[i]>target) break;
            cur.add(candidates[i]);
            backtrack(candidates, target-candidates[i], i, cur, res);
            cur.remove(cur.size()-1);
        }
    }
}