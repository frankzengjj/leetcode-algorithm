class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int a: asteroids) {
            if (a > 0) {
                stack.push(a);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(a)) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(a);
                } else if (stack.peek() + a == 0) {
                    stack.pop();
                }
            }
        }
        
        int size = stack.size();
        int[] res = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}