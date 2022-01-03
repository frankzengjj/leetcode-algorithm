class Node {
    public int val;
    public List<Node> children;
    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        // construct tree
        Node root = new Node(0, new ArrayList<>());
        Map<Integer, Node> map = new HashMap<>();
        map.put(0, root);
        for (int i=0; i<pid.size(); i++) {
            int parentVal = ppid.get(i), childVal = pid.get(i);
            Node parent = new Node(parentVal, new ArrayList<>());
            Node child = new Node(childVal, new ArrayList<>());
            map.putIfAbsent(parentVal, parent);
            map.putIfAbsent(childVal, child);
            map.get(parentVal).children.add(child);
        }
        
        // BFS
        List<Integer> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(map.get(kill));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                Node node = q.poll();
                res.add(node.val);
                for (Node child: node.children) {
                    //System.out.println(child.val);
                    q.add(map.get(child.val));
                }
            }
        }
        return res;
    }
}