class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map=new HashMap<>();
        String[] str_arr = str.split("\\s+");
        if(pattern.length()!=str_arr.length) return false;
        if(pattern.isEmpty()&&str.isEmpty()) return true;
        
        for(int i=0; i<str_arr.length; i++) {
            if(!map.containsKey(pattern.charAt(i)) && map.containsValue(str_arr[i])) {
                return false;
            }
            
            if(!map.containsKey(pattern.charAt(i))) {
                map.put(pattern.charAt(i), str_arr[i]);
            } else {
                if(!map.get(pattern.charAt(i)).equals(str_arr[i])) {
                    return false;
                }
            }
            
        }
        return true;
    }
}