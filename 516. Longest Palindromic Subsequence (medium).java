class Solution {

    public int lcs(int i, int j, String s1, String s2, Integer[][] cache) {
        if (i < 0 || j < 0) return 0;
        if (cache[i][j] != null) return cache[i][j];
        if (s1.charAt(i) == s2.charAt(j)) return cache[i][j] = 1 + lcs(i - 1, j - 1, s1, s2, cache);
        return cache[i][j] = Math.max(lcs(i - 1, j, s1, s2, cache), lcs(i, j - 1, s1, s2, cache));
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        return lcs(n - 1, n - 1, s, new StringBuilder(s).reverse().toString(), new Integer[n + 1][n + 1]);
    }
}