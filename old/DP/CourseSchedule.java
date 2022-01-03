import java.util.*;
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Construct graph using arraylist
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i)
            graph.add(new ArrayList<Integer>());
        for (int i = 0; i < prerequisites.length; ++i) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];            
            graph.get(course).add(prerequisite);
        }
        
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; ++i){
            if (dfs(i, graph, visited)) return false;
        }
        return true;
    }
    
    private boolean dfs(int curr, ArrayList<ArrayList<Integer>> graph, int[] visited) {
        // 0: not visited, 1: visiting, 2: visited
        visited[curr]=1;
        for(int neightbor: graph.get(curr)) {
            if(visited[neighbor]==1) {
                return true;
            }
            if(visited[neighbor==0] && dfs(neighbor, graph, visited)) {
                return true;
            }
        }
        visited[curr]=2;
        return false;
    }
}