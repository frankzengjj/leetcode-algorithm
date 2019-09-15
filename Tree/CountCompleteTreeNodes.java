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
    public int countNodes(TreeNode root) {
        int count = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (q.peek() != null) {
            TreeNode front = q.poll();
            q.add(front.left);
            q.add(front.right);
            count++;
        }
        return count;
    }
}
