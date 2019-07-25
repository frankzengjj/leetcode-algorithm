class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char task: tasks) {
            map.put(task, map.getOrDefault(task, 0)+1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2)->(n2-n1));
        maxHeap.addAll(map.values());
        int cycles = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new LinkedList<>();
            for(int i=0; i<n+1; i++) {
                if (!maxHeap.isEmpty()) {
                    temp.add(maxHeap.poll());
                }
            }
            
            for(int num: temp) {
                if (--num > 0) {
                    maxHeap.add(num);
                }
            }
            
            // A B A B A B, n=1
            
            cycles += maxHeap.isEmpty() ? temp.size() : n+1;
        }
        return cycles;
    }
}