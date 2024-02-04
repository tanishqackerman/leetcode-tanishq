import java.util.*;

class Solution {

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int rep = 0;
        Queue<Triad> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    vis[i][j] = true;
                    q.offer(new Triad(0, i, j));
                }
            }
        }
        while (!q.isEmpty()) {
            Triad t = q.poll();
            rep = Math.max(rep, t.d);
            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};
            for (int k = 0; k < 4; k++) {
                int nr = t.i + dr[k];
                int nc = t.j + dc[k];
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1 && !vis[nr][nc]) {
                    vis[nr][nc] = true;
                    q.offer(new Triad(t.d + 1, nr, nc));
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    rep = -1;
                }
            }
        }
        return rep;
    }
}

class Triad {
    int d, i, j;
    public Triad(int d, int i, int j) {
        this.d = d;
        this.i = i;
        this.j = j;
    }
}