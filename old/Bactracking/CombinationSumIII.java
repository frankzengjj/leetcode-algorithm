class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(k,n,1,new ArrayList<>(),res);
        return res;
    }
    
    private void dfs(int k, int n, int level, List<Integer> cur, List<List<Integer>> res) {
        if(n==0 && cur.size()==k &&!res.contains(cur) ) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        for(int i=level; i<10; i++) {
            if(i>n) return;
            cur.add(i);
            dfs(k,n-i,i+1, cur, res);
            cur.remove(cur.size()-1);
        }
    }
}