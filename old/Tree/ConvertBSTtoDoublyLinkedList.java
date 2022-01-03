/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root==null) return root;
        if (root.left==null && root.right==null) {
            root.left = root;
            root.right = root;
            return root;
        }
        List<Node> list = new LinkedList<>();
        inorder(root, list);
        
        for (int i=0; i<list.size(); i++) {
            if (i==0) {
                list.get(i).left = list.get(list.size()-1);
                list.get(i).right = list.get(i+1);
            } else if (i!=0 && i+1<list.size()) {
                list.get(i).right = list.get(i+1);
                list.get(i).left = list.get(i-1);
            }
        }
        list.get(list.size()-1).left = list.get(list.size()-2);
        list.get(list.size()-1).right = list.get(0);
        return list.get(0);
    }
    
    private void inorder(Node root, List<Node> list) {
        if(root==null){
            return;
        }
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }
}