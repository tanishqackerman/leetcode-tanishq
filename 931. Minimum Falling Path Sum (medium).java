class Solution {

    public int path(int i, int j, int[][] matrix, Integer[][] cache) {
        if (i >= matrix.length) return 0;
        if (j < 0 || j >= matrix.length) return Integer.MAX_VALUE;
        if (cache[i][j] != null) return cache[i][j];
        return cache[i][j] = matrix[i][j] + Math.min(path(i + 1, j - 1, matrix, cache), Math.min(path(i + 1, j, matrix, cache), path(i + 1, j + 1, matrix, cache)));
    }

    public int minFallingPathSum(int[][] matrix) {
        Integer[][] cache = new Integer[matrix.length][matrix.length];
        int rep = Integer.MAX_VALUE;
        for (int i = 0; i < cache.length; i++) {
            rep = Math.min(rep, path(0, i, matrix, cache));
        }
        return rep;
    }
}