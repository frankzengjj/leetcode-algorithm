class TicTacToe {
    
    private char[][] board;
    private char[] players;
    private String[] rowBoard;
    private String[] colBoard;
    private final String WIN_X;
    private final String WIN_O;
    private int n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        board = new char[n][n];
        this.rowBoard = new String[n];
        this.colBoard = new String[n];
        Arrays.fill(rowBoard, "");
        Arrays.fill(colBoard, "");
        this.players = new char[] {'$', 'X', 'O'};
        StringBuilder X = new StringBuilder();
        StringBuilder O = new StringBuilder();
        for (int i=0; i<n; i++) {
            X.append('X');
            O.append('O');
        }
        WIN_X = X.toString();
        WIN_O = O.toString();
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        board[row][col] = players[player];
        rowBoard[row] = new String(board[row]);
        
        StringBuilder colSb = new StringBuilder();
        for (int i=0; i<n; i++) {
            colSb.append(board[i][col]);
        }
        colBoard[col] = colSb.toString();
        
        return isWin(board, player) ? player : 0;
    }
    
    private boolean isWin(char[][] board, int player) {
        String winCond = player == 1 ? WIN_X : WIN_O;
        // check row
        // check col
        for (int i=0; i<n; i++) {
            if (rowBoard[i].equals(winCond) || colBoard[i].equals(winCond)) {
                return true;
            }
        }
        
        // diag check 1
        StringBuilder diag1 = new StringBuilder();
        for (int k=0; k<n; k++) {
            diag1.append(board[k][k]);
        }
        
        // diag check 2
        StringBuilder diag2 = new StringBuilder();
        int i=0, j=n-1;
        while (i < n && j >=0) {
            diag2.append(board[i++][j--]);
        }
        
        return diag1.toString().equals(winCond) || diag2.toString().equals(winCond);
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */