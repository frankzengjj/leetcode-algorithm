class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] paraArr = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        for (String word: paraArr) {
            if (!set.contains(word)) {
                map.put(word, map.getOrDefault(word, 0)+1);
            }
        }
        
        String res = "";
        int max = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }
}