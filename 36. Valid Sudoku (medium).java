class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                for (int k = 0; k < board.length; k++) {
                    if (j != k && board[i][j] != '.' && board[i][k] == board[i][j]) return false;
                }
                for (int k = 0; k < board.length; k++) {
                    if (i != k && board[i][j] != '.' && board[k][j] == board[i][j]) return false;
                }
                for (int k = (i / 3) * 3; k < (i / 3) * 3 + 3; k++) {
                    for (int l = (j / 3) * 3; l < (j / 3) * 3 + 3; l++) {
                        if (i != k && j != l && board[i][j] != '.' && board[i][j] == board[k][l]) return false;
                    }
                }
            }
        }
        return true;
    }
}