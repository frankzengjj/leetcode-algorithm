class Solution {
    public int findCircleNum(int[][] M) {
        int N = M.length;
        int count = 0;
        boolean[] visited = new boolean[N];
        for (int i=0; i<N; i++) {
            if (!visited[i]) {
                dfs(M, i, N, visited);
                count++;
            }
        }
        return count;
    }
    
    private void dfs(int[][] M, int i, int N, boolean[] visited) {
        for (int j = 0; j < N; j++) {
            if (M[i][j]==1 && !visited[j]) {
                visited[j] = true;
                dfs(M, j, N, visited);
            }
        }
    }
}