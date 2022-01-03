class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        String[] temp = strs.clone();
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0; i<temp.length; i++) {
            char[] ch = temp[i].toCharArray();
            Arrays.sort(ch);
            temp[i]=new String(ch);
            if(!map.containsKey(temp[i])) {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(strs[i]);
                map.put(temp[i], anagrams);
            } else {
                map.get(temp[i]).add(strs[i]);
            }
        }
        
        for(List<String> anagrams: map.values()) {
            res.add(anagrams);
        }
        return res;
    }
}