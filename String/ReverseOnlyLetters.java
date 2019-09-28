class Solution {
    public String reverseOnlyLetters(String S) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c: S.toCharArray()) {
            if (Character.isLetter(c)) {
                stack.push(c);
            }
        }
        
        StringBuilder res = new StringBuilder();
        for (char c: S.toCharArray()) {
            if (Character.isLetter(c)) {
                res.append(stack.pop());
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}