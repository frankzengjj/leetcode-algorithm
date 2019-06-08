class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length==0 || nums2.length==0) return new int[0];
        
        Map map = new HashMap();
        List<Integer> resList = new ArrayList<>();
        for(int i=0; i<nums2.length; i++) {
            if(!map.containsKey(nums2[i])) {
                map.put(nums2[i], 1);
            } else {
                map.put(nums2[i], (int)map.get(nums2[i])+1);
            }
        }
        
        for(int j=0; j<nums1.length; j++) {
            if(map.containsKey(nums1[j]) && (int)map.get(nums1[j]) > 0) {
                resList.add(nums1[j]);
                map.put(nums1[j], (int)map.get(nums1[j])-1);
            }
        }
        
        int[] res = new int[resList.size()];
        for(int k=0; k<res.length; k++) {
            res[k]=resList.get(k);
        }
        
        return res;
    }
}