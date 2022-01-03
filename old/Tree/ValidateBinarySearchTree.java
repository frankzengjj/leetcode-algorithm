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
    private List<Integer> nodeList=new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        for(int i=1; i<nodeList.size(); i++) {
            if(nodeList.get(i-1) >= nodeList.get(i)) {
                return false;
            }
        }
        return true;
    }
    
    private void inorder(TreeNode root) {
        if(root==null) {
            return;
        }
        
        inorder(root.left);
        nodeList.add(root.val);
        inorder(root.right);
    }
}