class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        boolean odd = false;
        for (Integer freq: map.values()) {
            if (freq % 2 == 0) {
                continue;
            } else {
                if (odd) {
                    return false;
                } else {
                    odd = true;
                }
            }
        }
        return true;
    }
}