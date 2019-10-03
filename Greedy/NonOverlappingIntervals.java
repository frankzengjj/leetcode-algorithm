class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) return 0;
        Arrays.sort(intervals, (l1, l2) -> {
            return l1[1] - l2[1];
        });
        
        int count = 1;
        int end = intervals[0][1];
        for (int i=1; i<intervals.length; i++) {
            if (intervals[i][0] >= end) {
                count++;
                end = intervals[i][1];
            }
        }
        return intervals.length - count;
    }
}