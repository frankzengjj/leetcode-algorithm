import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.*;

class Solution {
    public String crush(String str) {
        // aabbbacd
        //char[] arr = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        Deque<Character> st = new ArrayDeque<>();
        for (char c: str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
            if (map.get(c) >= 3) {
                while (!st.isEmpty() && st.peek() == c) {
                    st.pop();
                }
                map.put(c, 0);
            } else {
                st.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.crush("aabbccddeeedcba"));
    }
}