class Solution {
    public int maxArea(int[] height) {
        int lo=0;
        int hi=height.length-1;
        int maxArea=0;
        while(lo<hi){
            int side=Math.min(height[lo],height[hi]);
            int area=side*(hi-lo);
            if(area>maxArea) {
                maxArea=area;
            } else {
                if(height[lo]>height[hi]) {
                    hi--;
                } else {
                    lo++;
                }
            }
        }
        return maxArea;
    }
}