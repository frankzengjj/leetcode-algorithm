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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        q.add(root);
        // bfs
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i=0; i<size; i++) {
                TreeNode front = q.poll();
                level.add(front.val);
                if (front.left != null) q.add(front.left);
                if (front.right != null) q.add(front.right);
            }
            res.addFirst(level);
        }
        return res;
    }
}