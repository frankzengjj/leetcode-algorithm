/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Map<ListNode, ListNode> map = new HashMap<>();
        ListNode dummy = head;
        while(dummy!=null) {
            if(map.containsKey(dummy)) {
                return dummy;
            } else {
                map.put(dummy, dummy.next);
                dummy = dummy.next;
            }
        }
        return null;
    }
    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head, start = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (slow != start) {
                    slow = slow.next;
                    start = start.next;
                }
                return start;
            }
        }
        return null;
    }
}