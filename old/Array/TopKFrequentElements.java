class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
            new PriorityQueue<>((n1, n2) -> n1.getValue()-n2.getValue());
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int n : nums) {
             freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.add(entry);
            // Maintain top k frequent elements
            if(minHeap.size()>k) {
                minHeap.poll();
            }
        }
        
        List<Integer> res = new ArrayList<>();
        while(!minHeap.isEmpty()) {
            res.add(minHeap.poll().getKey());
        }
        return res;
    }
}