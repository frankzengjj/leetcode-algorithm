class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        String mid = "";
        int odd = 0;
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
            odd += map.get(c) % 2 != 0 ? 1 : -1;
        }
        
        if (odd > 1) return res;
        if (map.size() == 1) {
            res.add(s);
            return res;
        }
        
        
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if (val % 2 != 0) {
                mid += key;
            }
            for (int i=0; i<val/2; i++) list.add(key);
        }
        backtrack(list, mid, new boolean[list.size()], new StringBuilder(), res);
        return res;
    }
    
    private void backtrack(List<Character> list, String mid, boolean[] used, StringBuilder sb, List<String> res) {
        if (sb.length() == list.size()) {
            res.add(sb.toString() + mid + sb.reverse().toString());
            sb.reverse();
            return;
        }
        
        for (int i=0; i < list.size(); i++) {
            if (used[i]) continue;
            if (i > 0 && list.get(i) == list.get(i-1) && used[i-1]) continue;
            used[i] = true;
            sb.append(list.get(i));
            backtrack(list, mid, used, sb, res);
            used[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
        
    }
}