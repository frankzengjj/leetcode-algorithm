class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (c1, c2) -> ((c1[1] - c1[0]) - (c2[1] - c2[0])));
        int i = 0, j = costs.length - 1, cost = 0;
        while (i < j) {
            cost += costs[i++][1] + costs[j--][0];
        }
        return cost;
    }
}