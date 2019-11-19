class Solution {
    public int largestUniqueNumber(int[] A) {
        if (A.length == 0) return -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int max = -1;
        for (int num: A) {
            if (map.get(num) == 1) {
                max = Math.max(num, max);
            }
        }
        return max;
    }
}