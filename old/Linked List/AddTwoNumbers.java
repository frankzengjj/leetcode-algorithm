/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode temp = res;
        int carry = 0;
        while (l1 != null || l2 != null || carry == 1) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            ListNode newNode = new ListNode((x + y + carry) % 10);
            temp.next = newNode;
            temp = temp.next;
            carry = (x + y + carry) / 10;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return res.next;
    }
}