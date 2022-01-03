class Solution {
    public boolean isBipartite(int[][] graph) {
        if (graph==null || (graph.length<2 && graph[0].length==0)) return true;
        boolean[] visited = new boolean[graph.length];
        int[] color = new int[graph.length];
        Arrays.fill(color, 1);
        for (int i=0; i<graph.length; i++) {
            if (!visited[i] && !dfs(graph, i, visited, color)) {
                return false;
            }
        }
        return true;
        
    }
    
    private boolean dfs(int[][] graph, int node, boolean[] visited, int[] color) {
        for (int nei: graph[node]) {
            if (!visited[nei]) {
                visited[nei]=true;
                color[nei] = -1 * color[node];
                if (!dfs(graph, nei, visited, color)) {
                    return false;
                }
            } else {
                if (color[nei] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}