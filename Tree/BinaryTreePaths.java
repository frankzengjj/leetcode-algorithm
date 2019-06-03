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
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root!=null) {
            getTreePath(root, "", res);
        }
       return res;
    }
    
    public void getTreePath(TreeNode node, String path, List<String> result) {
        if(node.left==null && node.right==null) {
            result.add(path+node.val);
        }
        
        if(node.left!=null) {
            getTreePath(node.left, path+node.val+"->", result);
        }
        
        if(node.right!=null) {
            getTreePath(node.right, path+node.val+"->", result);
        }
        
    }
}