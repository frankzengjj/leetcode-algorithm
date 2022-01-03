class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n==0) return res;
        backtrack(res, n, n, "");
        return res;
    }
    
    private void backtrack(List<String> res, int left, int right, String str) {
        if(left>right) {
            return;
        }
        if(left==0 && right==0) {
            res.add(str);
            return;
        }
        if(left>0) {
            backtrack(res, left-1, right, str+"(");
        }
        if(right>0) {
            backtrack(res, left, right-1, str+")");
        }
    }
}