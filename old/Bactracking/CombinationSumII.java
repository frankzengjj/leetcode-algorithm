class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }
    
    private void backtrack(int[] candidates, int target, int level, List<Integer> cur, List<List<Integer>> res) {
        if(target==0) {
            if(!res.contains(cur))
                res.add(new ArrayList<>(cur));
            return;
        }
        
        for(int i=level; i<candidates.length; i++) {
            if(candidates[i]>target) return;
            cur.add(candidates[i]);
            backtrack(candidates, target-candidates[i], i+1, cur, res);
            cur.remove(cur.size()-1);
        }
    }
}