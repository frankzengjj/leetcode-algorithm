import java.util.*;

class MinimumCostConstruct {
    static class UnionFind {
        public int[] parent;
        public UnionFind(int size) {
            parent = new int[size];
            Arrays.fill(parent, -1);
        }

        private int findRoot(int p) {
            int p_root = p;
            while (parent[p_root] != -1) {
                p_root = parent[p_root];
            }
            return p_root;
        }

        public boolean union(int p, int q) {
            int p_root = findRoot(p);
            int q_root = findRoot(q);
            if (p_root == q_root) {
                return false;
            } else {
                parent[p_root] = q_root;
                return true;
            }
        }

        public boolean isConnected(int p, int q) {
            return findRoot(p) == findRoot(q);
        }
    }

    
    public static void main(String[] args) {
        UnionFind uf = new UnionFind(6);
        int[][] edges = new int[][] {
            {0,1}, {1,2}, {1,3},
            {3,4}, {2,5}
        };

        for (int[] edge: edges) {
            int p = edge[0], q = edge[1];
            if (!uf.union(p, q)) {
                System.out.println("Cycle Detected");
            }
        }
        System.out.println("No cycle");
    }
}