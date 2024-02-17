class Solution {

    public int rec(int i, int j, String s, String t, Integer[][] cache) {
        if (j < 0) return 1;
        if (i < 0) return 0;
        if (cache[i][j] != null) return cache[i][j];
        if (s.charAt(i) != t.charAt(j)) return cache[i][j] = rec(i - 1, j, s, t, cache);
        return cache[i][j] = rec(i - 1, j - 1, s, t, cache) + rec(i - 1, j, s, t, cache);
    }

    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        return rec(m - 1, n - 1, s, t, new Integer[m + 1][n + 1]);
    }
}