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
    public TreeNode deleteNode(TreeNode root, int key) {
        root = delete(root, key);
        return root;
    }
    
    private TreeNode delete(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val < key) {
            root.right = delete(root.right, key);
        } else if (root.val > key) {
            root.left = delete(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            int minVal = getMin(root.right);
            root.val = minVal;
            root.right = delete(root.right, root.val);
        }
        
        return root;
    }
    
    private int getMin(TreeNode node) {
        int min = node.val;
        while (node.left != null) {
            min = node.left.val;
            node = node.left;
        }
        return min;
    }
}