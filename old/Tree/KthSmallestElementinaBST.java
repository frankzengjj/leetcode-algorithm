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
    
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1,n2)->(n1-n2));
        inorder(root,k, maxHeap);
        return (int)maxHeap.toArray()[k-1];
    }
    
    private void inorder(TreeNode root, int k, PriorityQueue<Integer> maxHeap) {
        if(k==0 || root==null) {
            return;
        }
        
        inorder(root.left, k--, maxHeap);
        maxHeap.add(root.val);
        inorder(root.right, k--, maxHeap);
        
    }
}