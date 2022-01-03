class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(s, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(String s, List<String> temp, List<List<String>> res) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i=1; i<s.length()+1; i++) {
            if (isPalindrome(s.substring(0,i))) {
                temp.add(s.substring(0,i));
                dfs(s.substring(i), temp, res);
                temp.remove(temp.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}