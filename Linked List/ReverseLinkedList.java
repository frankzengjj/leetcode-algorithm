/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = head;
        ListNode nextNode = res.next;
        ListNode prev = nextNode;
        res.next = null;
        
        // 1 -> 2 -> 3 -> 4
        // null <- 1 2 -> 3 -> 4
    
        while (nextNode.next != null) {
            nextNode = nextNode.next;
            prev.next = res;
            res = prev;
            prev = nextNode;
        }
        nextNode.next = res;
        res = nextNode;
        return res;
    }
}