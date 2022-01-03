class Solution {
    public TreeNode invertTree(TreeNode root) {
        
        if (root == null) {
            return root;
        }

        TreeNode leftTemp = root.left;
        root.left=root.right;
        root.right=leftTemp;
        
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}