class Solution {

    public int lcs(int i, int j, String s1, String s2, Integer[][] cache) {
        if (i < 0 || j < 0) return 0;
        if (cache[i][j] != null) return cache[i][j];
        if (s1.charAt(i) == s2.charAt(j)) return cache[i][j] = 1 + lcs(i - 1, j - 1, s1, s2, cache);
        return cache[i][j] = Math.max(lcs(i - 1, j, s1, s2, cache), lcs(i, j - 1, s1, s2, cache));
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int rep = lcs(n - 1, m - 1, word1, word2, new Integer[n + 1][m + 1]);
        return Math.abs(n - rep) + Math.abs(m - rep);
    }
}