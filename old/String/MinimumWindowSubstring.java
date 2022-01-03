class Solution {
    public String minWindow(String s, String t) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int counter = map.size();
        
        int left = 0, right = 0, maxlen = Integer.MAX_VALUE, head = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) counter--;
            }
            right++;
            
            while (counter == 0) {
                char tempc = s.charAt(left);
                if (map.containsKey(tempc)) {
                    map.put(tempc, map.get(tempc)+1);
                    if (map.get(tempc) > 0) counter++;
                }
                if (right - left < maxlen) {
                    maxlen = right - left;
                    head = left; 
                }
                left++;
            }
        }
        return maxlen == Integer.MAX_VALUE ? "" : s.substring(head, head+maxlen);
    }
}