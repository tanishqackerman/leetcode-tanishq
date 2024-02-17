class Solution {

    public int rec(int i, int j, String s1, String s2, Integer[][] cache) {
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;
        if (cache[i][j] != null) return cache[i][j];
        if (s1.charAt(i) == s2.charAt(j)) return cache[i][j] = rec(i - 1, j - 1, s1, s2, cache);
        return cache[i][j] = 1 + Math.min(rec(i, j - 1, s1, s2, cache), Math.min(rec(i - 1, j, s1, s2, cache), rec(i - 1, j - 1, s1, s2, cache)));
    }

    public int minDistance(String str1, String str2) {
        if (str1.length() == 0) return str2.length();
        int n = str1.length(), m = str2.length();
        return rec(n - 1, m - 1, str1, str2, new Integer[n + 1][m + 1]);
    }
}