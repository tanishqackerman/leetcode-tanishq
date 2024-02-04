import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Queue<Triad> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) continue;
                q.offer(new Triad(0, i, j));
                vis[i][j] = true;
            }
        }
        while (!q.isEmpty()) {
            Triad t = q.poll();
            mat[t.i][t.j] = t.d;
            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};
            for (int k = 0; k < 4; k++) {
                int nr = t.i + dr[k];
                int nc = t.j + dc[k];
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && !vis[nr][nc]) {
                    vis[nr][nc] = true;
                    q.offer(new Triad(t.d + 1, nr, nc));
                }
            }
        }
        return mat;
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