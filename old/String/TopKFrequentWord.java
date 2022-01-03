class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
            (e1, e2) -> (e1.getValue() == e2.getValue() ? e2.getKey().compareTo(e1.getKey()) : e1.getValue() - e2.getValue())
        );
        
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        List<String> res = new LinkedList<>();
        while(!minHeap.isEmpty()) {
            res.add(0,minHeap.poll().getKey());
        }
        return res;
    }
}