class Solution {
    public boolean checkValidString(String s) {
        int min_op = 0, max_op = 0;
       for (char c: s.toCharArray()) {
           if (c=='(') {
               min_op++;
           } else {
               min_op--;
           }
           
           if (c!=')') {
               max_op++;
           } else {
               max_op--;
           }
           
           if (max_op < 0) return false;
           min_op = Math.max(0, min_op);
       }
    
        return min_op==0;
    }
}