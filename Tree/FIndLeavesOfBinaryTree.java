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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, root);
        return res;
    }
    
    private int dfs(List<List<Integer>> res, TreeNode root) {
        if (root == null) return -1;
        int left = dfs(res, root.left);
        int right = dfs(res, root.right);
        int height = Math.max(left, right) + 1;
        if (res.size() == height) {
            res.add(new ArrayList<>());
        }
        res.get(height).add(root.val);
        //root.left = root.right = null;
        return height;
    }
}