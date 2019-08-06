class Solution {
    public int minAddToMakeValid(String S) {
        if (S.length() == 0) return 0;
        int left = 0, right = 0;
        for (char paren: S.toCharArray()) {
            if (paren == '(') {
                left++;
            }
            if (paren == ')') {
                if (left == 0) {
                    right++;
                } else {
                    left--;
                }
            }
        }
        return left+right;
    }
}