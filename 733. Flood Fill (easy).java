class Solution {

    public void dfs(int[][] image, int sr, int sc, int color, int init) {
        int m = image.length, n = image[0].length;
        image[sr][sc] = color;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        for (int k = 0; k < 4; k++) {
            int nr = sr + dr[k];
            int nc = sc + dc[k];
            if (nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == init) {
                dfs(image, nr, nc, color, init);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int pix = image[sr][sc];
        if (pix == color) {
            return image;
        }
        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }
}