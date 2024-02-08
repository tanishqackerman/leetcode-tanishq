class Solution {
    public int minPathSum(int[][] cache) {
        int m = cache.length, n = cache[0].length;
        for (int i = m - 2; i >= 0; i--) {
            cache[i][n - 1] += cache[i + 1][n - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            cache[m - 1][i] += cache[m - 1][i + 1];
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                cache[i][j] = cache[i][j] + Math.min(cache[i + 1][j], cache[i][j + 1]);
            }
        }
        return cache[0][0];
    }
}