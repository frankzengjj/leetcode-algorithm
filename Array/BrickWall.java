public class Solution {
    public int leastBricks(List < List < Integer >> wall) {
        Map<Long, Integer> gaps = new HashMap<>();
            int maxGaps = 0;
            for(List<Integer> row : wall) {
                long sum = 0;
                for(int i = 0; i < row.size() - 1; i++) {
                    sum += row.get(i);
                    gaps.put(sum, gaps.getOrDefault(sum, 0) + 1);
                    maxGaps = Math.max(maxGaps, gaps.get(sum));
                }
            }
        return wall.size() - maxGaps;
    }
}