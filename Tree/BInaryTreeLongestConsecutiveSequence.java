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
    public int maxLen = 0;
    public int longestConsecutive(TreeNode root) {
        dfs(null, root, 0);
        return maxLen;
    }
    
    private void dfs(TreeNode parent, TreeNode child, int length) {
        if (child == null) return;
        length = (parent != null && child.val == parent.val + 1) ? length + 1 : 1;
        maxLen = Math.max(maxLen, length);
        dfs(child, child.left, length);
        dfs(child, child.right, length);
    }
}