class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // -2 -1 0 0 1 2
        Arrays.sort(nums); 
        List<List<Integer>> res = new LinkedList<>(); 
        
        for(int i=0; i<nums.length-3; i++) {
            if(i==0 || (i>0 && nums[i]!=nums[i-1])) {
                for(int j=i+1; j<nums.length-2; j++) {
                    if(j==i+1 || nums[j]!=nums[j-1]) {
                        int lo=j+1, hi=nums.length-1, sum=target-nums[i]-nums[j];
                        while(lo<hi) {
                            if(sum==nums[lo]+nums[hi]) {
                                res.add(Arrays.asList(nums[i],nums[j],nums[lo],nums[hi]));
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
            }
        }
        return res;
    }
}