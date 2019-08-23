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
        List<Integer> num1 = new LinkedList<>();
        List<Integer> num2 = new LinkedList<>();
        
        while (l1 != null) {
            num1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            num2.add(l2.val);
            l2 = l2.next;
        }
        
        List<Integer> res = new ArrayList<>();
        int carry = 0;
        for (int i=num1.size()-1, j=num2.size()-1; i>=0 || j>=0 || carry==1; i--, j--)  {
            int a = i<0 ? 0 : num1.get(i);
            int b = j<0 ? 0 : num2.get(j);
            res.add(0, (a+b+carry) % 10);
            carry = (a+b+carry) / 10;
        }
        
        ListNode start = new ListNode(0);
        ListNode temp = start;
        for (int val: res) {
            ListNode node = new ListNode(val);
            temp.next = node;
            temp = temp.next;
        }
        return start.next;
    }
}