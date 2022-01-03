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
    List<Integer> sums = new ArrayList<>();
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) {
            return false;
        }
        
        getPathSums(root, 0, sums);
        for(int val: sums) {
            if(val==sum) {
                System.out.println(val);
                return true;
            }
        }
        return false;
    }
    
    public void getPathSums(TreeNode node, int pathSum, List<Integer> sums) {
        if(node.left==null && node.right==null) {
            sums.add(pathSum+node.val);
        }
        if(node.left!=null) {
            getPathSums(node.left, pathSum+node.val, sums);
        }
        if(node.right!=null) {
            getPathSums(node.right, pathSum+node.val, sums);
        }
    }
    
}