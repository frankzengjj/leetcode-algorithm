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
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int[] arr = new int[size];
            for (int i=0; i<size; i++) {
                TreeNode front = q.poll();
                arr[i] = front.val;
                boolean isX = false, isY = false;
                if (front.left != null) {
                    if (front.left.val == x) isX = true;
                    if (front.left.val == y) isY = true;
                    q.add(front.left);
                }
                
                if (front.right != null) {
                    if (front.right.val == x) isX = true;
                    if (front.right.val == y) isY = true;
                    q.add(front.right);
                }
                if (isX && isY) return false;
            }
            boolean xSeen = false, ySeen = false;
            for (int node: arr) {
                if (node == x) xSeen = true;
                if (node == y) ySeen = true;
            }
            
            if (xSeen && ySeen) return true;
            if ((!xSeen && ySeen) || (xSeen && !ySeen)) return false;
        }
        return false;
    }
}