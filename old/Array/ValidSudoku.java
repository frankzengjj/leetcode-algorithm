class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++) {
            Set<Character> rowCount = new HashSet<>();
            Set<Character> colCount = new HashSet<>();
            Set<Character> cube = new HashSet<>();
            for(int j=0; j<9; j++) {
                if(board[i][j]!='.' && !rowCount.add(board[i][j])) return false;
                if(board[j][i]!='.' && !colCount.add(board[j][i])) return false;
                int RowIndex = 3*(i/3);
                int ColIndex = 3*(i%3);
                if(board[RowIndex + j/3][ColIndex + j%3]!='.' && 
                   !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                    return false;
                
            }
        }
        return true;
    }
}