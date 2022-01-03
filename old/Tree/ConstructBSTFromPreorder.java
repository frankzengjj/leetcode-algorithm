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
    public int i=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return dfs(preorder, Integer.MAX_VALUE);
    }
    
    private TreeNode dfs(int[] preorder, int bound) {
        
        if (i == preorder.length || preorder[i] > bound) return null;
        TreeNode node = new TreeNode(preorder[i++]);
        node.left = dfs(preorder, node.val);
        node.right = dfs(preorder, bound);
        return node;
    }
}