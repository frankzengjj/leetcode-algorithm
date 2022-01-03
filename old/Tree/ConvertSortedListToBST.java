/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }
        System.out.println(arr.toString());
        return helper(arr, 0, arr.size() - 1);
    }
    
    private TreeNode helper(List<Integer> arr, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = right + (left - right) / 2;
        TreeNode root = new TreeNode(arr.get(mid));
        if (left == right) {
            return root;
        }
        root.left = helper(arr, left, mid-1);
        root.right = helper(arr, mid+1, right);
        return root;
    }
}