/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return head;
        Map<Node, Node> map = new HashMap<>();
        Node res = dfs(head, map);
        return res;
    }
    
    private Node dfs(Node node, Map<Node, Node> map) {
        if(node==null) {
            return null;
        }
        if(map.containsKey(node)) {
            return map.get(node);
        }
        
        Node newNode = new Node();
        newNode.val = node.val;
        map.put(node, newNode);
        newNode.next=dfs(node.next, map);
        newNode.random=dfs(node.random, map);
        return newNode;
    }
}