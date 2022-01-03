class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] map = new int[26];
        for (char c: p.toCharArray()) {
            map[c-'a']++;
        }
        int left=0, right=0, count=p.length();
        while (right<s.length()) {
            if (map[s.charAt(right)-'a'] > 0) {
                count--;
            }
            map[s.charAt(right)-'a']--;
            
            if (right-left+1==p.length()) {
                if (count==0) {
                    res.add(left);
                }
                if (map[s.charAt(left)-'a']>=0) {
                    count++;
                }
                map[s.charAt(left)-'a']++;
                left++;
            }
            right++;
        }
        return res;
    }
}