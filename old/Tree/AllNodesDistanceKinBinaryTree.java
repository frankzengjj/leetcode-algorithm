/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if (K==0) {res.add(target.val); return res;}
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        // build graph
        dfs(graph, null, root);
        
        // bfs
        q.add(target);
        visited.add(target);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                TreeNode front = q.poll();
                for (TreeNode nei: graph.get(front)) {
                    if (!visited.contains(nei)) {
                        q.add(nei);
                        visited.add(nei);
                    }
                } 
            }
            
            if (--K == 0) {
                while (!q.isEmpty()) {
                    res.add(q.poll().val);
                }
            }
        }
        return res;
    }
    
    private void dfs(Map<TreeNode, List<TreeNode>> map, TreeNode parent, TreeNode child) {
        if (child == null) return;
        map.putIfAbsent(child, new ArrayList<TreeNode>());
        if (parent != null) {
            map.get(parent).add(child);
            map.get(child).add(parent);
        }
        dfs(map, child, child.left);
        dfs(map, child, child.right);
    }
}