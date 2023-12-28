class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        if (n > m) return false;
        int i = 0, j = 0;
        while (i < n) {
            if (j == m) return false;
            if (s.charAt(i) == t.charAt(j++)) i++;
        }
        return true;
    }
}