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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> path=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) {
            return ans;
        }
        getPath(root, sum, path, ans);
        return ans;
    }
    
    private void getPath(TreeNode root, int sum, List<Integer> path, List<List<Integer>> ans) {
        path.add(root.val);
        // leaf node
        if(root.left==null && root.right==null) {
            if(root.val==sum) {
                // add new copy of path
                ans.add(new ArrayList<Integer>(path));
            }
        } else {
            if(root.left!=null) {
                getPath(root.left, sum-root.val, path, ans);
            }
            if(root.right!=null) {
                getPath(root.right, sum-root.val, path, ans);
            }
        }
        path.remove(path.size()-1);
    }
}