import java.util.*;
class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put('0', '0');
            put('1', '1');
            put('6', '9');
            put('8', '8');
            put('9', '6');
        }};
        StringBuilder sb = new StringBuilder();
        for (int i=num.length() - 1; i >= 0; i--) {
            if (!map.containsKey(num.charAt(i))) {
                return false;
            }
            sb.append(map.get(num.charAt(i)));
        }
        
        return sb.toString().equals(num);
    }
}