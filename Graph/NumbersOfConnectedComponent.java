class Solution {
    public int countComponents(int n, int[][] edges) {
        if (edges.length == 0) return n;
        boolean[][] adj = new boolean[n][n];
        boolean[] visited = new boolean[n];
        for (int[] edge: edges) {
            adj[edge[0]][edge[1]] = true;
            adj[edge[1]][edge[0]] = true;
        }
        
        int res = 0;
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                res++;
                dfs(visited, adj, i);
            }
        }
        return res;
    }
    
    private void dfs(boolean[] visited, boolean[][] adj, int i) {
        visited[i] = true;
        for (int j=0; j<adj[i].length; j++) {
            if (!visited[j] && adj[i][j]) {
                dfs(visited, adj, j);
            }
        }
    }
}