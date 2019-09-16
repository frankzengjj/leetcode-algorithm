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
    private int ans = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        dfs(root, L, R);
        return ans;
    }
    
    private void dfs(TreeNode root, int L, int R) {
        if (root == null) return;
        if (root.val >= L && root.val <= R) {
            ans += root.val;
        }
        
        if (L < root.val) {
            dfs(root.left, L, R);
        }
        
        if (R > root.val) {
            dfs(root.right, L, R);
        }
    }
}
