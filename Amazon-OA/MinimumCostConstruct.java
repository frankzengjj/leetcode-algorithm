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

    public static int getMinimumCostConstruct(int n, int numTotalAvaiableRoads, List<List<Integer>> roadsAvailable, int numNewRoadsContruct,  List<List<Integer>> costNewRoadsConstruct) {
        int res = 0;
        UnionFind uf = new UnionFind(n+1);

        // O(nlogn)
        Collections.sort(costNewRoadsConstruct, (e1, e2) -> (e1.get(2) - e2.get(2)));
        Set<String> set = new HashSet<>();
        for (List<Integer> edge: costNewRoadsConstruct) {
            set.add(edge.get(0) + "<->" + edge.get(1));
        }

        int edgeNum = 0;
        for (List<Integer> road: roadsAvailable) {
            int c1 = road.get(0), c2 = road.get(1);
            String edge = c1 + "<->" + c2;
            // remove duplicates
            if (set.contains(edge)) continue;
            // union two cities when they are not connected
            if (uf.union(c1, c2)) edgeNum++;
        }

        for (List<Integer> road: costNewRoadsConstruct) {
            int c1 = road.get(0), c2 = road.get(1), cost = road.get(2);
            if (uf.union(c1, c2)) {
                edgeNum++;
                res += cost;
            }
            
            if (edgeNum == n - 1) {
                return res;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int numTotalAvailableCities = 6;
        int numTotalAvailableRoads = 3;
        //[[1, 4], [4, 5], [2, 3]]
        List<List<Integer>> roadsAvailable = Arrays.asList(
            Arrays.asList(1,4),
            Arrays.asList(4,5),
            Arrays.asList(2,3)
        );
        int numNewRoadsConstruct = 4;
        //[[1, 2, 5], [1, 3, 10], [1, 6, 2], [5, 6, 5]]
        List<List<Integer>> costNewRoadsConstruct = Arrays.asList(
            Arrays.asList(1,2,5),
            Arrays.asList(1,3,10),
            Arrays.asList(1,6,2),
            Arrays.asList(5,6,5)
        );

        int res = getMinimumCostConstruct(numTotalAvailableCities, 
                                            numTotalAvailableRoads, 
                                            roadsAvailable, 
                                            numNewRoadsConstruct, 
                                            costNewRoadsConstruct);

        System.out.println(res);
    }
}