class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        LinkedList<String> res = new LinkedList<>();
        for (List<String> iti: tickets) {
            graph.putIfAbsent(iti.get(0), new PriorityQueue<String>());
            graph.get(iti.get(0)).add(iti.get(1));
        }
        
        res.add("JFK");
        dfs(res, graph, "JFK");
        res.remove(res.size()-1);
        return res;
    }
    
    private void dfs(List<String> res, Map<String, PriorityQueue<String>> graph, String start) {
        PriorityQueue<String> q = graph.get(start);
        while (q!=null && !q.isEmpty()) {
            dfs(res, graph, q.poll());
        }
        res.add(0,start);
    }
    
}