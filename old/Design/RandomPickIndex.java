class Solution {
    private int[] nums;
    private Map<Integer, List<Integer>> map;
    private Random rand = new Random();
    
    public Solution(int[] nums) {
        this.nums=nums;
        map=new HashMap<>();
        store(map, this.nums);
    }
    
    private void store(Map<Integer, List<Integer>> map, int[] nums) {
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                List<Integer> indices=new LinkedList<>();
                indices.add(i);
                map.put(nums[i], indices);
            }
        }
    }
    
    public int pick(int target) {
        List<Integer> res=map.get(target);
        int index = rand.nextInt(res.size());
        return res.get(index);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */