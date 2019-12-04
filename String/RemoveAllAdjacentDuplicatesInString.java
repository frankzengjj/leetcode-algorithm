class Solution {
    public String removeDuplicates(String S) {
        if (S.length() == 0) return "";
        Deque<Character> st = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (char c: S.toCharArray()) {
            if (!st.isEmpty() && st.peek() == c) {
                st.pop();
            } else {
                st.push(c);
            }
        }
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}