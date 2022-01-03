class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1,n2)->(n1-n2));
        for(int i=0; i<k; i++) {
            minHeap.add(nums[i]);
        }
        
        for(int j=k; j<nums.length; j++) {
            if(nums[j]>minHeap.peek()) {
                minHeap.poll();
                minHeap.add(nums[j]);
            }
        }
        
        return minHeap.peek();
    }
}