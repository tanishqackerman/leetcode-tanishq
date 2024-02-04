class Solution {

    public void dfs(int i, int j, int[][] grid, boolean[][] vis) {
        int m = grid.length, n = grid[0].length;
        vis[i][j] = true;
        grid[i][j] = -1;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        for (int k = 0; k < 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];
            if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1 && !vis[nr][nc]) {
                dfs(nr, nc, grid, vis);
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int rep = 0;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1 && !vis[i][0]) dfs(i, 0, grid, vis);
            if (grid[i][n - 1] == 1 && !vis[i][n - 1]) dfs(i, n - 1, grid, vis);
        }
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1 && !vis[0][i]) dfs(0, i, grid, vis);
            if (grid[m - 1][i] == 1 && !vis[m - 1][i]) dfs(m - 1, i, grid, vis);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) rep++;
            }
        }
        return rep;
    }
}