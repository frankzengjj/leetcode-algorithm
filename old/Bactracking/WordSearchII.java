class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (String target: words) {
            if (isExist(board, target)) {
                res.add(target);
            }
        }
        return res;
    }
    
    private boolean search(char[][] board, int r, int c, int i, String target) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || target.charAt(i) != board[r][c]) return false;
        
        if (i+1 == target.length()) return true;
        char cur = board[r][c];
        board[r][c] = '#';
        boolean res = search(board, r+1, c, i+1, target) ||
                       search(board, r-1, c, i+1, target) ||
                       search(board, r, c+1, i+1, target) ||
                       search(board, r, c-1, i+1, target);
        board[r][c] = cur;
        return res;
    }
    
    private boolean isExist(char[][] board, String target) {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] == target.charAt(0) && search(board, i, j, 0, target)) {
                    return true;
                }
            }
        }
        return false;
    }
}
