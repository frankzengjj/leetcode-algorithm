class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap 
            = new PriorityQueue<>((n1, n2)->(n2.getValue()-n1.getValue()));
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }
        maxHeap.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        
        Queue<Map.Entry<Character, Integer>> q = new LinkedList<>();
        //<a, 3> <b, 2> <c, 2> <d, 1>
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> top = maxHeap.poll();
            sb.append(top.getKey());
            top.setValue(top.getValue()-1);
            q.add(top);
            
            if (q.size()<2) continue;
            Map.Entry<Character, Integer> front = q.poll();
            if (front.getValue()>0) {
                maxHeap.add(front);
            }
            
        }
        return sb.length()==s.length() ? sb.toString() : "";
    }
}
