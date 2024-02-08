import java.util.*;

class Solution {

    public int triangle(int i, int j, List<List<Integer>> triangle, int[][] cache) {
        if (i >= triangle.size()) return 0;
        if (cache[i][j] != -1) return cache[i][j];
        return cache[i][j] = triangle.get(i).get(j) + Math.min(triangle(i + 1, j, triangle, cache), triangle(i + 1, j + 1, triangle, cache));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] cache = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        for (int i = 0; i < cache.length; i++) Arrays.fill(cache[i], -1);
        return triangle(0, 0, triangle, cache);
    }
}