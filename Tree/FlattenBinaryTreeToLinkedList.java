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
    public void flatten(TreeNode root) {
        dfs(root);
    }
    
    private TreeNode dfs(TreeNode node) {
        if (node == null) {
            return null;
        }
        
        TreeNode leftLast = dfs(node.left);
        TreeNode rightLast = dfs(node.right);
        
        if (leftLast != null) {
            leftLast.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        
        if (rightLast != null) return rightLast;
        if (leftLast != null) return leftLast;
        return node;
    }
}