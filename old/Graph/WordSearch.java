class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length, n=board[0].length;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (dfs(i, j, m, n, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(int row, int col,int m, int n, char[][] board, String word, int d) {
        if (row < 0 || col < 0 || row >= m || col >= n || board[row][col] != word.charAt(d)) {
            return false;
        }
        if (d == word.length()-1) return true;
        
        char cur = board[row][col];
        board[row][col] = '$';
        boolean found = dfs(row+1, col, m, n, board, word, d+1) ||
                        dfs(row-1, col, m, n, board, word, d+1) || 
                        dfs(row, col+1, m, n, board, word, d+1) ||
                        dfs(row, col-1, m, n, board, word, d+1);
        board[row][col] = cur;
        return found;
    }
}