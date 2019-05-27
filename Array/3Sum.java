class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // -4 -1 -1 0 1 2
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for(int i=0; i<nums.length; i++) {
            int p1=i+1;
            int p2=p1+1;
            while(p2<nums.length) {
                if(nums[p1]+nums[p2]==nums[i]){
                    res.add(Arrays.asList(nums[i], nums[p1], nums[p2]));
                }
                p2++;
            }
        }
        return res;
    }
}