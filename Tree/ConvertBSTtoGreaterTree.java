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
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        inorder(root);
        return root;
    }
    
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        
        inorder(root.right);
        root.val += sum;
        sum = root.val;
        inorder(root.left);
    }
}