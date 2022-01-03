class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        int pre = 0;
        // pre means the start of the interval
        for(String log: logs) {
            String[] arr = log.split(":");
            if(arr[1].equals("start")) {
                // arr[2] is the start of next interval, doesn't belong to current interval.
                if(!st.isEmpty()) result[st.peek()] += Integer.parseInt(arr[2]) - pre;
                st.push(Integer.parseInt(arr[0]));
                pre = Integer.parseInt(arr[2]);
            } else {
                // arr[2] is end of current interval, belong to current interval. That's why we have +1 here
                result[st.pop()] += Integer.parseInt(arr[2]) - pre + 1;
                // pre means the start of next interval, so we need to +1
                pre = Integer.parseInt(arr[2]) + 1;
            }
        }
        return result;
    }
}