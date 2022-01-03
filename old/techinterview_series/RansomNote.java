class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() == 0) return true;
        Map<Character, Integer> map = new HashMap<>();
        for (char c: magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (char r: ransomNote.toCharArray()) {
            if (map.get(r) == null || map.get(r) == 0) return false;
            map.put(r, map.getOrDefault(r, 0) - 1);
        }
        return true;
    }
}