class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0]; 
        int row = matrix.length, col = matrix[0].length, r = 0, c = 0, k = 0;
        int[][] dirs = new int[][] {{-1, 1}, {1, -1}};
        int[] res = new int[row*col];
        for (int i=0; i<row*col; i++) {
            res[i] = matrix[r][c];
            r = r + dirs[k][0];
            c = c + dirs[k][1];
            if (r >= row) {r = row - 1; c += 2; k = 1 - k;}
            if (c >= col) {c = col - 1; r += 2; k = 1 - k;}
            if (r < 0) {r = 0; k = 1 - k;}
            if (c < 0) {c = 0; k = 1 - k;}
        }
        return res;
    }
}