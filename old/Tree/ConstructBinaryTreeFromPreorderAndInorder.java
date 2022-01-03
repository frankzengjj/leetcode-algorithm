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
    int preIndex = 0;
    Map<Integer, Integer> map = new HashMap<>(); 
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, inorder.length);
    }
    
    private TreeNode buildTree(int[] preorder, int[] inorder, int left, int right) {
        if (left == right) return null;
        TreeNode root = new TreeNode(preorder[preIndex++]);
        int index = map.get(root.val);
        root.left = buildTree(preorder, inorder, left, index);
        root.right = buildTree(preorder, inorder, index+1, right);
        return root;
    }
}