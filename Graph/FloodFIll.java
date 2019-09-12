class Solution {
    // 0 0 0 
    // 0 1 1
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (newColor == image[sr][sc]) return image;
        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    
    private void dfs(int[][] m, int row, int col, int color, int startColor) {
        if (row < 0 || col < 0 || row >= m.length || col >= m[0].length || m[row][col] != startColor) return;
        m[row][col] = color;
        dfs(m, row-1, col, color, startColor);
        dfs(m, row+1, col, color, startColor);
        dfs(m, row, col-1, color, startColor);
        dfs(m, row, col+1, color, startColor);
    }
}