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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<TreeNode>();
        bfs.add(root);
        while (bfs.peek() != null) {
            TreeNode node = bfs.poll();
            bfs.add(node.left);
            bfs.add(node.right);
        }
        
        while (!bfs.isEmpty() && bfs.peek() == null)
            bfs.poll();
        return bfs.isEmpty();
    }
}