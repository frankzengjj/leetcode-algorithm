class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i=0; i<n; i++) map.put(i, new HashMap<>());
        for (int[] flight: flights) {
            map.get(flight[0]).put(flight[1], flight[2]);
        }
        
        // [price, city, remaining stop]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        minHeap.add(new int[]{0, src, K+1});
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int price = top[0], city = top[1], stop = top[2];
            if (city == dst) return price;
            if (stop > 0) {
                Map<Integer, Integer> nei = map.get(city);
                for (Map.Entry<Integer, Integer> entry: nei.entrySet()) {
                    minHeap.add(new int[]{entry.getValue()+price, entry.getKey(), stop-1});
                }
            }
        }
        return -1;
    }
}