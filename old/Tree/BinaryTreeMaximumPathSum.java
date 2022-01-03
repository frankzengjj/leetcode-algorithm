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
    int ans;
    public int maxPathSum(TreeNode root) {
        ans=Integer.MIN_VALUE;
        maxPathDown(root);
        return ans;
    }
    
    private int maxPathDown(TreeNode node) {
        if(node==null) {
            return 0;
        }
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        ans=Math.max(left+right+node.val, ans);
        return Math.max(left, right)+node.val;
    }
}