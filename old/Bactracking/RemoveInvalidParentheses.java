class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length()==0) {
            res.add("");
            return res;
        }
        int left=0, right=0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)=='(') left++;
            if (s.charAt(i)==')') {
                if (left==0) {
                     right++;
                } else {
                    left--;
                }
            } 
        }
        //System.out.println(left+'  '+right);
        dfs(s, 0, left, right, res);
        return res;
    }
    
    // 1. check if the string is valid
    private boolean isValid(String s) {
        int count = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)=='(') {
                count++;
            }
            if (s.charAt(i)==')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
            
        }
        return count==0;
    }
    
    private void dfs(String s, int start, int left, int right, List<String> res) {
        if (left==0 && right==0) {
            if (isValid(s)) {
                res.add(s);
            }
            return;
        }
        for (int i=start; i<s.length(); i++) {
            if (i!=0 && s.charAt(i) == s.charAt(i-1)) continue;
            String curr = s;
            curr = curr.substring(0,i) + curr.substring(i+1);
            if (right>0) {
                dfs(curr, i, left, right-1, res);
            } else if (left>0) {
                dfs(curr, i, left-1, right, res);
            }
        }
    }
}