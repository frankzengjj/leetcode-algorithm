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
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        List<String> res = new ArrayList<>();
        dfs(res, "", root);
        int sum = 0;
        for (String path: res) {
            sum += Integer.parseInt(path);
        }
        return sum;
    }
    private void dfs(List<String> res, String path, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(path+root.val);
            return;
        }
        
        dfs(res, path+root.val, root.left);
        dfs(res, path+root.val, root.right);
    }
}
