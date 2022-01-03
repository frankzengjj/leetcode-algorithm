/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i=0; i<level; i++) {
                TreeNode top = queue.poll();
                sb.append(String.valueOf(top.val)+',');
                if (top.left != null) {
                    queue.add(top.left);
                }
                if (top.right != null) {
                    queue.add(top.right);
                }
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        TreeNode root = null;
        for (String s : arr) {
            if (s.length() > 0) {
                root = buildBST(root, Integer.parseInt(s));
            }
        }
        return root;
    }

    public TreeNode buildBST(TreeNode root, int v) {
        if (root == null) return new TreeNode(v);
        if (v < root.val) {
            root.left = buildBST(root.left, v);
        } else {
            root.right = buildBST(root.right, v);
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));