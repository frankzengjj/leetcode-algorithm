import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new LinkedList<>();
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        Set<String> emails = new HashSet<>();
        
        for (List<String> list: accounts) {
            String name = list.get(0);
            for (int i=1; i<list.size(); i++) {
                String email = list.get(i);
                emails.add(email);
                emailToName.put(email, name);
                graph.putIfAbsent(email, new HashSet<String>());
                if (i==1) continue;
                graph.get(list.get(i-1)).add(email);
                graph.get(email).add(list.get(i-1));
            }
        }
        
        Set<String> visited = new HashSet<>();
        for (String email: emails) {
            if (visited.add(email)) {
                List<String> tmp = new LinkedList<>();
                dfs(email, graph, visited, tmp);
                Collections.sort(tmp);
                tmp.add(0, emailToName.get(email));
                res.add(tmp);
            }
        }
        return res;
    }
    
    private void dfs(String email, Map<String, Set<String>> graph, Set<String> visited, List<String> tmp) {
        
        tmp.add(email);
        visited.add(email);
        for (String neighbor: graph.get(email)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited, tmp);
            }
        }
    }
}
