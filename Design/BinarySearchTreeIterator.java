class BSTIterator {
    
    private TreeNode root;
    private int index = 0;
    private List<Integer> list;
    
    public BSTIterator(TreeNode root) {
        this.root = root;
        list = new LinkedList<>();
        inorder(root, list);
    }
    
    private void inorder(TreeNode root, List<Integer> list) {
        if(root==null) {
            return;
        }
        
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    /** @return the next smallest number */
    public int next() {
        return list.get(index++);
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index!=list.size();
    }
}
