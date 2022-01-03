class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(n,k,1,new ArrayList<>(), res);
        return res;
    }
    
    private void backtrack(int n, int k, int pos, List<Integer> combination, List<List<Integer>> res) {
        if(combination.size()==k) {
            res.add(new ArrayList<>(combination));
            return;
        }
        
        for(int i=pos; i<=n; i++) {
            combination.add(i);
            backtrack(n,k,i+1,combination,res);
            combination.remove(combination.size()-1);
        }
    }
}