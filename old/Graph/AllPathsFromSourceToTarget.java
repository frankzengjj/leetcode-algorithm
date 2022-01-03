class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer, int[]> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        int src = 0, dst = graph.length-1;
        // build graph
        for (int i=0; i<graph.length; i++) {
            map.put(i, graph[i]);
        }
        
        Queue<List<Integer>> q = new LinkedList<>();
        List<Integer> initPath = new ArrayList<>();
        initPath.add(0);
        q.add(initPath);
        
        // BFS
        while (!q.isEmpty()) {
            List<Integer> path = q.poll();
            int last = path.get(path.size()-1);
            if (last == dst) {
                res.add(path);
            }
            for (int nei: map.get(last)) {
                if (!path.contains(nei)) {
                    List<Integer> newPath = new ArrayList<>(path);
                    newPath.add(nei);
                    q.add(newPath);
                }
            }
        }
        
        return res;
    }
}