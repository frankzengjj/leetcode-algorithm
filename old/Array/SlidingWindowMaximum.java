class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return new int[0];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2)->(n2-n1));
        int[] res = new int[nums.length - k + 1];
        for (int i=0; i<k; i++) {
            maxHeap.add(nums[i]);
        }
        res[0] = maxHeap.peek();
        for (int i=k; i<nums.length; i++) {
            maxHeap.remove(nums[i-k]);
            maxHeap.add(nums[i]);
            res[i-k+1] = maxHeap.peek();
        }
        return res;
    }
}
