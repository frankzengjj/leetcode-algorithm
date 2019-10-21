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
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        int level = 1;
        q.add(root);
        int maxSum = root.val, minLevel = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            for (int i=0; i<size; i++) {
                TreeNode front = q.poll();
                sum += front.val;
                if (front.left != null) {
                    q.add(front.left);
                } 
                if (front.right != null) {
                    q.add(front.right);
                }
            }
            if (sum > maxSum) {
                maxSum = sum;
                minLevel = level;
            }
            level++;
        }
        return minLevel;
    }
}