class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        for (int i=0; i<nums1.length; i++) {
            set.add(nums1[i]);
        }
        
        for (int i=0; i<nums2.length; i++) {
            if(set.contains(nums2[i]) && !resSet.contains(nums2[i])) {
                resSet.add(nums2[i]);
            }
        }
        
        int[] res = new int[resSet.size()];
        int index=0;
        for (Integer i: resSet) {
            res[index++]=i;
        } 
        
        return res;
        
    }
}