class Solution {

    public int lcs(int i, int j, String s1, String s2, Integer[][] cache) {
        if (i < 0 || j < 0) return 0;
        if (cache[i][j] != null) return cache[i][j];
        if (s1.charAt(i) == s2.charAt(j)) return cache[i][j] = 1 + lcs(i - 1, j - 1, s1, s2, cache);
        return cache[i][j] = Math.max(lcs(i - 1, j, s1, s2, cache), lcs(i, j - 1, s1, s2, cache));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        return lcs(n - 1, m - 1, text1, text2, new Integer[n + 1][m + 1]);
    }
}