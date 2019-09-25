/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = head;
        
        while (dummy != null) {
            ListNode ne = dummy.next;
            while (ne != null && ne.val == dummy.val) {
                ne = ne.next;
            }
            dummy.next = ne;
            dummy = ne;
        }
        
        return head;
    }
}