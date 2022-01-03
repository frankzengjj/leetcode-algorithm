class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        List<Integer> res = new ArrayList<>();
        int len = colors.length;
        int[][] left = new int[len][4];
        int[][] right = new int[len][4];
        for (int[] p : left) 
            Arrays.fill(p, -1);
        for (int[] p : right) 
            Arrays.fill(p, -1);
        for (int i=0, j=len-1; i<len && j >=0; ++i, --j) {
            left[i][colors[i]] = i;
            right[j][colors[j]] = j;
            if (i > 0) {
                for (int k=1; k<=3; k++) {
                    if (k != colors[i])
                        left[i][k] = left[i-1][k];
                }
            }
            if (j < len-1) {
                for (int k=1; k<=3; k++) {
                    if (k != colors[j])
                        right[j][k] = right[j+1][k];
                }
            }
        }
        
        for (int[] q: queries) {
            int index = q[0], color = q[1];
            if (left[index][color] == -1 && right[index][color] == -1) {
                res.add(-1);
            } else if (left[index][color] == -1 || right[index][color] == -1) {
                int resIndex = left[index][color] == -1 ? right[index][color] : left[index][color];
                res.add(Math.abs(resIndex - index));
            } else {
                res.add(Math.min(index - left[index][color], right[index][color] - index));
            }
        }
        
        return res;
    }
}