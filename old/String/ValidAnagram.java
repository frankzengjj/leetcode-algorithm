class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] s_set = new int[26];
        int[] t_set = new int[26];
        
        for(int i=0; i<s.length(); i++) {
            s_set[s.charAt(i)-'a']+=1;
            t_set[t.charAt(i)-'a']+=1;
        }
        
        for(int j=0; j<26; j++) {
            if(s_set[j]!=t_set[j]) {
                return false;
            }
        }
        return true;
    }
}