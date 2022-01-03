/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.val = insertVal;
            node.next = node;
            return node;
        }
        
        Node max = head;
        while (max.val <= max.next.val && max.next != head) max = max.next;
        Node min = max.next, cur = min;
        
        if (insertVal <= min.val || insertVal >= max.val) {
            max.next = new Node(insertVal, min);
        } else {
            while (cur.next.val < insertVal) cur = cur.next;
            cur.next = new Node(insertVal, cur.next);
        }
        return head;
    }
}
