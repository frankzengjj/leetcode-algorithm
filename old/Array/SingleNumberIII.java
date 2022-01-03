class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        int i=0;
        for (Map.Entry entry: map.entrySet()) {
            if ((int)entry.getValue() == 1) res[i++] = (int)entry.getKey();
        }
        
        return res;
    }
}