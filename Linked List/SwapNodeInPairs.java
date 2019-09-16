/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode slow = head;
        ListNode fast = slow.next;
        
        while (fast != null) {
            ListNode ne = fast.next;
            fast.next = slow;
            slow.next = ne;
            prev.next = fast;
            prev = slow;
            slow = ne;
            if (slow == null) break;
            fast = slow.next;
        }
        return dummy.next;
    }
}
