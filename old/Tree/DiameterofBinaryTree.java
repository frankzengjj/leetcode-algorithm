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
    private int treeDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return treeDiameter;
    }
    
    private int helper(TreeNode root) {
        if (root==null) {
            return 0;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        int diameter = left+right;
        treeDiameter = Math.max(treeDiameter, diameter);
        return Math.max(left, right)+1;
    }
}