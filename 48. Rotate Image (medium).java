class Solution {
    public void rotate(int[][] mat) {
        int n = mat.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                int tmp = mat[i][j];
                mat[i][j] = mat[n - 1 - j][n - 1 - i];
                mat[n - 1 - j][n - 1 - i] = tmp;
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n / 2; i++) {
                int temp = mat[i][j];
                mat[i][j] = mat[n - i - 1][j];
                mat[n - i - 1][j] = temp;
            }
        }
    }
}