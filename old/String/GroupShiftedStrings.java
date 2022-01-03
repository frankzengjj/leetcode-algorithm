class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if (strings.length == 0) return res;
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strings) {
            String key = "";
            for (int i=1; i<str.length(); i++) {
                int diff = str.charAt(i) - str.charAt(i-1);
                if (diff < 0) {
                    diff += 26;
                }
                key += diff + ",";
            }
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        
        for (Map.Entry<String, List<String>> entry: map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}