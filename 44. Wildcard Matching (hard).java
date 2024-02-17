class Solution {

    public boolean rec(int i, int j, String s, String p, Boolean[][] cache) {
        if (i < 0 && j < 0) return true;
        if (i < 0){
            for (int k = 0 ; k <= j ; k++) if (p.charAt(k) != '*') return false;
            return true;
        }
        if (j < 0) return false;
        if (cache[i][j] != null) return cache[i][j];
        if (p.charAt(j) == '*') return rec(i - 1, j, s, p, cache) || rec(i, j - 1, s, p, cache);
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') return rec(i - 1, j - 1, s, p, cache);
        return false;
    }

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        return rec(m - 1, n - 1, s, p, new Boolean[m + 1][n + 1]);
    }
}