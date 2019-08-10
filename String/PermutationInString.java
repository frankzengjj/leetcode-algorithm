class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() == 0 && s2.length() == 0) return false;
        if (s1.length() == 0) return true;
        int len = s1.length();
        Set<Character> set = new HashSet<>();
        for (char c: s1.toCharArray()) set.add(c);
        for (int i=0; i<s2.length(); i++) {
            if (set.contains(s2.charAt(i)) && i+len <= s2.length() && isAnagram(s1, s2.substring(i,i+len))) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isAnagram(String s1, String s2) {
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for (char c: s1.toCharArray()) {
            map1[c-'a']+=1;
        }
        for (char c: s2.toCharArray()) {
            map2[c-'a']+=1;
        }
        
        for (int i=0; i<26; i++) {
            if (map1[i] != map2[i]) {
                return false;
            }
        }
        return true;
    }
}