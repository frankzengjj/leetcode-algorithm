class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length==0) return 0;
        Arrays.sort(intervals, (i1, i2)->(i1[0]-i2[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2)->(n1-n2));
        for (int i=0; i<intervals.length; i++) {
            if (!minHeap.isEmpty() && minHeap.peek() <= intervals[i][0]) {
                minHeap.poll();
            }
            minHeap.add(intervals[i][1]);
        }
        return minHeap.size();
    }
}