class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] m = new int[26];
        for (int i=0; i<26; i++) {
            m[order.charAt(i)-'a']=i;
        }
        
        for (int i=1; i<words.length; i++) {
            if (compare(words[i-1], words[i], m) > 0) {
                return false;
            } 
        }
        return true;
    }
    
    private int compare(String s1, String s2, int[] map) {
        int n=s1.length(), m=s2.length();
        int cmp = 0;
        for (int i=0, j=0; i<n && j<m && cmp==0; i++, j++) {
            int pos1 = map[s1.charAt(i)-'a'];
            int pos2 = map[s2.charAt(j)-'a'];
            cmp = pos1 - pos2;
        }
        return cmp==0 ? n-m : cmp;
    }
}