class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return find(root, k, new HashSet<>());
    }
    
    private boolean find(TreeNode root, int target, Set<Integer> set) {
        if (root == null) return false;
        if (set.contains(target - root.val)) return true;
        set.add(root.val);
        return find(root.left, target, set) || find(root.right, target, set);
    }
}