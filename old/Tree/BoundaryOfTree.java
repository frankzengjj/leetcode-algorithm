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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res= new ArrayList<>();
        if (root == null) return res;
        res.add(root.val);
        leftBoundary(root.left, res);
        leaves(root.left, res);
        leaves(root.right, res);
        rightBoundary(root.right, res);
        return res;
    }
    
    // preorder
    private void leftBoundary(TreeNode root, List<Integer> res) {
        if (root == null || (root.left == null && root.right == null)) return;
        res.add(root.val);
        if (root.left == null) {
            leftBoundary(root.right, res);
        } else {
            leftBoundary(root.left, res);
        }
    }
    
    // post order
    private void rightBoundary(TreeNode root, List<Integer> res) {
        if (root == null || (root.left == null && root.right == null)) return;
        if (root.right == null) {
            rightBoundary(root.left, res);
        } else {
            rightBoundary(root.right, res);
        }
        res.add(root.val);
    }
    
    private void leaves(TreeNode root, List<Integer> res) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        leaves(root.left, res);
        leaves(root.right, res);
    }
}