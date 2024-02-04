class Solution {

    public void dfs(int i, int j, char[][] board, boolean[][] vis) {
        int m = board.length, n = board[0].length;
        vis[i][j] = true;
        board[i][j] = 'M';
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        for (int k = 0; k < 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];
            if (nr >= 0 && nc >= 0 && nr < m && nc < n && board[nr][nc] == 'O' && !vis[nr][nc]) {
                dfs(nr, nc, board, vis);
            }
        }
    }

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O' && !vis[i][0]) dfs(i, 0, board, vis);
            if (board[i][n - 1] == 'O' && !vis[i][n - 1]) dfs(i, n - 1, board, vis);
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O' && !vis[0][i]) dfs(0, i, board, vis);
            if (board[m - 1][i] == 'O' && !vis[m - 1][i]) dfs(m - 1, i, board, vis);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'M') board[i][j] = 'O';
            }
        }
    }
}