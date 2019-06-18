/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        Node node=root.next;
        while(node!=null) {
            if(node.left!=null) {
                node=node.left;
                break;
            } 
            if(node.right!=null) {
                node=node.right;
                break;
            }
            node=node.next;
        }
        if(root.right!=null) root.right.next = node;
        if(root.left!=null) root.left.next = root.right!=null ? root.right : node;
        connect(root.right);
        connect(root.left);
        return root;
    }
}