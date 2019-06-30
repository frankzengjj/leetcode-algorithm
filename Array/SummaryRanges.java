class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums==null || nums.length==0) return res;
        int pt = 0;
        for(int i=1; i<nums.length; i++) {
            if(nums[i]-nums[i-1] != 1) {
                if(i-pt==1) {
                    res.add(String.valueOf(nums[pt]));
                    pt=i;
                } else {
                    res.add(String.valueOf(nums[pt])+"->"+String.valueOf(nums[i-1]));
                    pt=i;
                }
            }
        }
        
        if(pt == nums.length-1) {
            res.add(String.valueOf(nums[pt]));
        } else {
            res.add(String.valueOf(nums[pt])+"->"+String.valueOf(nums[nums.length-1]));
        }
        return res;
    }
}