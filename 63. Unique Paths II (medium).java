class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] cache = new int[m][n];
        int f = 1;
        for (int i = m - 1; i >= 0; i--) {
            if (obstacleGrid[i][n - 1] == 1) f = 0;
            cache[i][n - 1] = f;
        }
        f = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (obstacleGrid[m - 1][i] == 1) f = 0;
            cache[m - 1][i] = f;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                cache[i][j] = obstacleGrid[i][j] == 0 ? cache[i + 1][j] + cache[i][j + 1] : 0;
            }
        }
        return cache[0][0];
    }
}