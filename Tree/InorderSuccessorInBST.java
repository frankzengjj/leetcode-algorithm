class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return (left != null) ? left : root;
        }
    }

    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        if (root == null) return null;
        List<TreeNode> res = new LinkedList<>();
        inorder(root, res);
        if (res.get(res.size()-1).val == p.val) return null;
        for (int i=1; i<res.size(); i++) {
            if (res.get(i-1).val == p.val) {
                return res.get(i);
            }
        }
        return null;
    }
    
    private void inorder(TreeNode root, List<TreeNode> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root);
        inorder(root.right, res);
    }
}