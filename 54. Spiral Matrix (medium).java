import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int i = 0, j = 0, m = matrix.length, n = matrix[0].length;
        List<Integer> rep = new ArrayList<>();
        rep.add(matrix[i][j]);
        boolean[][] vis = new boolean[m][n];
        while (!vis[i][j]) {
            vis[i][j] = true;
            while (j < n - 1 && !vis[i][j + 1]) {
                vis[i][j] = true;
                rep.add(matrix[i][++j]);
            } 
            while (i < m - 1 && !vis[i + 1][j]) {
                vis[i][j] = true;
                rep.add(matrix[++i][j]);
            } 
            while (j > 0 && !vis[i][j - 1]) {
                vis[i][j] = true;
                rep.add(matrix[i][--j]);
            } 
            while (i > 0 && !vis[i - 1][j]) {
                vis[i][j] = true;
                rep.add(matrix[--i][j]);
            }
        }
        return rep;
    }
}