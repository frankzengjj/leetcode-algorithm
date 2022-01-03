import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals==null || intervals.length==0) return new int[intervals.length][];
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int[] interval: intervals) {
            if(interval[0]<=end) {
                end=Math.max(end, interval[1]);
            } else {
                res.add(new int[]{start, end});
                start=interval[0];
                end=interval[1];
            }
        }
        res.add(new int[] {start, end});
       return res.toArray(new int[][] {});
    }


    /**
     * Assume a list of non-overlaped sorted intervals. 
     * Insert a new interval and return merged intervals
     * 
     * [1,5], [6,9], [10,13]. target = [4 7]
     * return [1,9] [10, 13]
     * 
     * @param intervals
     * @param target
     * @return
     */
    public List<int[]> merge(List<int[]> intervals, int[] target) {

        // 1. find the correct place to insert
        //       cur_interval.end < target.start
        // 2. merge all the intervals that overlap with target
        //       cur_interval.start < target.end 
        // 3. add remaining intervals to list
        List<int[]> res = new ArrayList<>();
        int i=0;

        // step 1
        while (i < intervals.size() && intervals.get(i)[1] < target[0]) {
            res.add(intervals.get(i++));
        }

        // step 2
        while (i < intervals.size() && intervals.get(i)[0] <= target[1]) {
            target[0] = Math.min(intervals.get(i)[0], target[0]);
            target[1] = Math.max(intervals.get(i)[1], target[1]);
            i++;
        }
        res.add(target);

        // step 3
        while (i < intervals.size()) {
            res.add(intervals.get(i++));
        }

        return res;
    }
}