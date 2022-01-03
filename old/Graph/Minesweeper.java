class Solution {
    // up down left right, tl, bl, tr, br
    int[] moveX = new int[]{-1, 1, 0, 0, -1, 1, -1, 1};
    int[] moveY = new int[]{0, 0, -1, 1, -1, -1, 1, 1};
    
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0], col = click[1];
        // If a mine ('M') is revealed, then the game is over - change it to 'X'.
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        }
        // If an empty square ('E') with no adjacent mines is revealed, 
        // then change it to revealed blank ('B') 
        // and all of its adjacent unrevealed squares should be revealed recursively.
        dfs(board, row, col);
        return board;
    }
    
    private void dfs(char[][] board, int row, int col) {
        int m=board.length, n=board[0].length;
        if (row < 0 || col < 0 || row >= m || col >= n || board[row][col] != 'E') {
            return;
        }
        
        int mines = numsOfMines(board, row, col);
        if (mines == 0) {
            board[row][col] = 'B';
            for (int i=0; i<8; i++) {
                int newX = row + moveX[i], newY = col + moveY[i];
                dfs(board, newX, newY);
            }
        } else {
            board[row][col] = (char) (mines + '0');
        }
    }
    
    private int numsOfMines(char[][] board, int row, int col) {
        int m=board.length, n=board[0].length;
        int nums = 0;
        for (int i=0; i<8; i++) {
            int newX = row + moveX[i], newY = col + moveY[i];
            if (newX < 0 || newY < 0 || newX >= m || newY >= n) continue;
            if (board[newX][newY] == 'M') nums++;
        }
        return nums;
    }
}