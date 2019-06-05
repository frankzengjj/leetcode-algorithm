class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.equals(t)) return true;
        Map<Character, Character> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            if(!map.containsKey(s.charAt(i)) && !map.containsValue(t.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        String res="";
        for(int i=0; i<s.length(); i++) {
            res+=map.get(s.charAt(i));
        }
        
        System.out.println(res);
        return res.equals(t);
    }

    public boolean isIsomorphic2(String s1, String s2) {
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();
    
        for(Integer i = 0; i < s1.length(); i++) {

            if(m1.put(s1.charAt(i), i) != m2.put(s2.charAt(i), i)) {
                return false;
            }
        }
        return true;
    }
}