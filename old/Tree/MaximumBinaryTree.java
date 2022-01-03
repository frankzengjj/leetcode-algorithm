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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums);
    }
    
    private TreeNode build(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        
        int m = getMaxIndex(nums);
        int[] left = Arrays.copyOfRange(nums, 0, m);
        int[] right = Arrays.copyOfRange(nums, m+1, nums.length);
        TreeNode root = new TreeNode(nums[m]);
        
        root.left = build(left);
        root.right = build(right);
        return root;
    }
    
    private int getMaxIndex(int[] nums) {
        int res=0, max = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            if (max<nums[i]) {
                max = nums[i];
                res = i;
            }
        }
        return res;
    }
}