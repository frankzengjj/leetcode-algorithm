class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> (n2 - n1));
        for (int stone: stones) pq.add(stone);
        while (pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();
            int res = y - x;
            pq.add(res);
        }
        
        return pq.isEmpty() ? 0 : pq.peek();
        
    }
}