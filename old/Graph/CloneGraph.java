/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        Node[] visited = new Node[101];
        return dfs(node, visited);
    }
    
    private Node dfs(Node node, Node[] visited) {
        if(node==null) return null;
        if(visited[node.val]!=null) return visited[node.val];
        
        Node newNode = new Node(node.val, new ArrayList<>());
        visited[node.val]=newNode;
        for(Node neighbor: node.neighbors) {
            newNode.neighbors.add(dfs(neighbor, visited));
        }
        return newNode;
    }
}