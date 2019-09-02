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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;
        int level = 0;
        q.add(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for (int i=0; i<size; i++) {
                TreeNode front = q.poll();
                temp.add(front.val);
                if (front.left != null) q.add(front.left);
                if (front.right != null) q.add(front.right);
            }
            
            if (level % 2 != 0) {
                Collections.reverse(temp);
            } 
            level++;
            res.add(temp);
        }
        return res;
    }
}