class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length, n = board[0].length, count = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 'X') {
                    count++;
                    dfs(board, i, j, m, n);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] board, int row, int col, int m, int n) {
        if (row < 0 || col < 0 || row >=m || col >= n || board[row][col] != 'X') {
            return;
        }
        
        board[row][col] = '.';
        dfs(board, row+1, col, m, n);
        dfs(board, row-1, col, m, n);
        dfs(board, row, col+1, m, n);
        dfs(board, row, col-1, m, n);
    }
}