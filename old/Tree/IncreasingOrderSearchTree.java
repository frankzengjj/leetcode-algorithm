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
    
    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);
        TreeNode res = new TreeNode(-1);
        TreeNode dummy = res;
        for (TreeNode node: list) {
            dummy.right = new TreeNode(node.val);
            dummy = dummy.right;
        }
        return res.right;
    }
    
    private void inorder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }
    
    
}