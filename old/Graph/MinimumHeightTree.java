class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges.length == 0) return new ArrayList<>(Arrays.asList(0));
        Map<Integer, Set<Integer>> g = new HashMap<>();
        for (int i=0; i<n; i++) g.put(i, new HashSet<>());
        for (int[] edge: edges) {
            int s=edge[0], t=edge[1];
            g.get(s).add(t);
            g.get(t).add(s);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int j=0; j<n; j++) {
            if (g.get(j).size() == 1) leaves.add(j); 
        }
       
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf: leaves) {
                int nei = g.get(leaf).iterator().next();
                g.get(nei).remove(leaf);
                g.remove(leaf);
                if (g.get(nei).size() == 1) newLeaves.add(nei);
            }
            leaves = newLeaves;
        }
            
            
        return leaves;
    }
}