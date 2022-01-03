class Solution {
    public String customSortString(String S, String T) {
        StringBuilder sb = new StringBuilder();
        int[] count = new int[26];
        for (char c: T.toCharArray()) count[c-'a']++; 
        
        for (char c: S.toCharArray()) {
            while (count[c-'a'] > 0) {
                sb.append(c);
                count[c-'a']--;
            }
        }
        
        for (int i=0; i<count.length; i++) {
            while (count[i] > 0) {
                sb.append((char)(i+97));
                count[i]--;
            }
        }
        return sb.toString();
    }
}