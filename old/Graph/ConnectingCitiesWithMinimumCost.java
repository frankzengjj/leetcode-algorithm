class Solution {
    class UnionFind {
        
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
    
    
    public int minimumCost(int N, int[][] connections) {
        Arrays.sort(connections, (a1, a2) -> (a1[2] - a2[2]));
        int edgeCnt = 0;
        int res = 0;
        UnionFind uf = new UnionFind(N+1);
        for (int[] edge: connections) {
            if (uf.union(edge[0], edge[1])) {
                edgeCnt++;
                res += edge[2];
            }
            
            if (edgeCnt >= N-1) {
                return res;
            }
        }
        return -1;
    }
}