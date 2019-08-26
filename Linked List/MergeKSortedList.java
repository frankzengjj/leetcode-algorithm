/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((l1, l2) -> (l1.val - l2.val));
        for (ListNode node: lists) {
            if (node != null)
                minHeap.add(node);
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        while (!minHeap.isEmpty()) {
            ListNode top = minHeap.poll();
            dummy.next = top;
            if (top.next != null) {
                minHeap.add(top.next);
            }
            dummy = dummy.next;
        }
        return res.next;
    }
}