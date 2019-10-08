class Solution {
    public int minCost(int[][] costs) {
        int c1 = costs[0][0], c2 = costs[0][1], c3 = costs[0][2];
        for (int i=1; i<costs.length; i++) {
            int tmp1 = Math.min(c2, c3) + costs[i][0];
            int tmp2 = Math.min(c1, c3) + costs[i][1];
            int tmp3 = Math.min(c1, c2) + costs[i][2];
            c1 = tmp1;
            c2 = tmp2;
            c3 = tmp3;
        }
        
        return Math.min(Math.min(c1,c2),c3);
    }
}