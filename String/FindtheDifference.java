class Solution {
    public char findTheDifference(String s, String t) {
        int[] sArr = new int[26];
        int[] tArr = new int[26];
        for(int i=0; i<s.length(); i++) {
            sArr[s.charAt(i)-'a']+=1;
        }
        for(int i=0; i<t.length(); i++) {
            tArr[t.charAt(i)-'a']+=1;
        }
        
        for(int j=0; j<26; j++) {
            if(sArr[j]!=tArr[j]) {
                return (char)(j+'a');
            }
        }
        return 'a';
        
    }
}