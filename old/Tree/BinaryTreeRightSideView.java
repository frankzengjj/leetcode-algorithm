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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, 1, map);
        int depth = 1;
        while (map.containsKey(depth)) {
            res.add(map.get(depth++));
        }
        return res;
    }
    
    private void dfs(TreeNode root, int depth, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        map.put(depth, root.val);
        dfs(root.left, depth+1, map);
        dfs(root.right, depth+1, map);
    }
}