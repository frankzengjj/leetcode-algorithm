class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // -4 -1 -1 0 1 2
        // -2 0 0 2 2
        Arrays.sort(nums); 
        List<List<Integer>> res = new LinkedList<>(); 
        for(int i=0; i<nums.length-2; i++) {
            if(i==0 || (i>0 && nums[i]!=nums[i-1])) {
                int lo=i+1, hi=nums.length-1, sum=0-nums[i];
                while(lo<hi) {
                    if(sum==nums[lo]+nums[hi]) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while(lo<hi && nums[lo]==nums[lo+1]) lo++;
                        while(lo<hi && nums[hi]==nums[hi-1]) hi--;
                        lo++;
                        hi--;
                    } else if(sum>nums[lo]+nums[hi]) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }
}