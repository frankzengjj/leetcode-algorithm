import java.util.*;
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Construct graph using arraylist
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<Integer> topOrder = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i)
            graph.add(new ArrayList<Integer>());
        for (int i = 0; i < prerequisites.length; ++i) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];            
            graph.get(course).add(prerequisite);
        }
        
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; ++i){
            if (dfs(i, graph, visited, topOrder)) return new int[0];
        }
        
        int[] res = new int[topOrder.size()];
        for(int i=0; i<topOrder.size(); i++) {
            res[i]=topOrder.get(i);
        }
        return res;
    }
    
    private boolean dfs(int curr, ArrayList<ArrayList<Integer>> graph, int[] visited, ArrayList<Integer> topOrder) {
        // 0: not visited, 1: visiting, 2: visited
        if (visited[curr] == 1) return true;
        if (visited[curr] == 2) return false;
        
        visited[curr] = 1;
                
        for (int next : graph.get(curr))
            if (dfs(next, graph, visited, topOrder)) return true;
        
        visited[curr] = 2;
        topOrder.add(curr);
        return false;
    }
}