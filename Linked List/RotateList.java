/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        List<Integer> list = new ArrayList<>();
        while (head!=null) {
            list.add(head.val);
            head = head.next;
        }
        
        int[] res = rotate(list, k);
        ListNode resNode = new ListNode(res[0]);
        ListNode dummy = resNode;
        for (int i=1; i<res.length; i++) {
            ListNode node = new ListNode(res[i]);
            dummy.next = node;
            dummy = dummy.next;
        }
        return resNode;
    }
    
    private int[] rotate(List<Integer> arr, int k) {
        int[] a = new int[arr.size()];
        for (int i=0; i<arr.size(); i++) {
            a[(i+k) % arr.size()] = arr.get(i);
        }
        return a;
    }
}