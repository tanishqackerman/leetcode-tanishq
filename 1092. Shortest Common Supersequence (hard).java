import java.util.*;

class Solution {

    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        Integer[][] cache = new Integer[n + 1][m + 1];
        for (Integer[] row: cache) Arrays.fill(row, -1);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) cache[i][j] = 1 + cache[i - 1][j - 1];
                else cache[i][j] = Math.max(cache[i - 1][j], cache[i][j - 1]);
            }
        }
        int i = n, j = m;
        String rep = "";
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                rep += str1.charAt(i - 1);
                i--;
                j--;
            } else if (cache[i - 1][j] >= cache[i][j - 1]) {
                rep += str1.charAt(i - 1);
                i--;
            } else if (cache[i - 1][j] < cache[i][j - 1]) {
                rep += str2.charAt(j - 1);
                j--;
            }
        }
        while (i > 0) {
            rep += str1.charAt(i - 1);
            i--;
        }
        while (j > 0) {
            rep += str2.charAt(j - 1);
            j--;
        }
        return new StringBuilder(rep).reverse().toString();
    }
}