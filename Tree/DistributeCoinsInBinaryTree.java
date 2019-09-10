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
    int steps = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return steps;
    }

    public int dfs(TreeNode node) {
        if(node == null) return 0;
        // coin from children -- post-order traversal
        int coin = dfs(node.left) + dfs(node.right);
        // current node coin
        
        coin += node.val - 1; // keep one coin for current node
        System.out.println(coin);
        steps += Math.abs(coin); // each coin move up to parent node need 1 step
        return coin; 
    }
}