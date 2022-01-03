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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if (root==null) return res;
        q.add(root);
        col.add(0);
        int min=0, max=0;
        
        while (!q.isEmpty()) {
            int colNum = col.poll();
            TreeNode node = q.poll();
            if (!map.containsKey(colNum)) {
                map.put(colNum, new LinkedList<>());
            }
            map.get(colNum).add(node.val);
            
            if (node.left!=null) {
                q.add(node.left);
                col.add(colNum-1);
                min = Math.min(min, colNum-1);
            }
            
            if (node.right!=null) {
                q.add(node.right);
                col.add(colNum+1);
                max = Math.max(max, colNum+1);
            }
        }
        
        
        for (int i=min; i<=max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}