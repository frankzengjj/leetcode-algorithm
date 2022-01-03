class KthLargest {
    private PriorityQueue<Integer> pq;
    private int size;
    private int res;
    
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>(k, (n1, n2) -> (n1-n2));
        size = k;
        for (int num: nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        if (pq.size() < size) {
            pq.add(val);
        } else if (pq.peek() < val) {
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */