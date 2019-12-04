class Solution {
    public String minRemoveToMakeValid(String s) {
        int left = 0;
        StringBuilder sb = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    continue;
                }
            }
            sb.append(c);
        }
        if (left > 0) {
            StringBuilder res = new StringBuilder();
            for (int i=sb.length()-1; i>=0; i--) {
                if (sb.charAt(i) == '(' && left-- > 0) {
                    continue;
                }
                res.append(sb.charAt(i));
            }
            return res.reverse().toString();
        }
        
        return sb.toString();
    }
}