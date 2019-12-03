import java.util.ArrayDeque;

class Solution {
    public String crush(String str) {
        char[] arr = str.toCharArray();
        char lastSeen = arr[0];
        ArrayDeque<Character> deque = new ArrayDeque();
        deque.add(arr[0]);
        for (int i=1; i<arr.length; i++) {
            while (deque.isEmpty()) {
                deque.add(arr[i]);
                i++;
                lastSeen = arr[i];
            }
            char last = deque.getLast();
            if (arr[i] == lastSeen) {
                if (arr[i] == last) {
                    deque.pollLast();
                    lastSeen = arr[i];
                } else {
                    i++;
                }
            } else {
                deque.add(arr[i]);
                lastSeen = arr[i];
            }
        }
        String res = "";
        while (!deque.isEmpty()) {
            res += deque.pollFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.crush("aaccca"));
    }
}