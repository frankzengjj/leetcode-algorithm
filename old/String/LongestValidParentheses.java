class Solution {
    public int longestValidParentheses(String s) {
        int left = -1, res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    left = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        res = Math.max(res, i-left);
                    } else {
                        res = Math.max(res, i-stack.peek());
                    }
                }
            }
        }
        return res;
    }
}