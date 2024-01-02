import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int n = s.length(), m = t.length();
        HashMap<Character, Integer> mal = new HashMap<>();
        for (int i = 0; i < m; i++) mal.put(t.charAt(i), mal.getOrDefault(t.charAt(i), 0) + 1);
        int i = 0, j = 0, count = mal.size();
        String rep = "";
        int f = 0;
        while (j < n) {
            while (j < n && count != 0) {
                final char ch = s.charAt(j);
                if (mal.containsKey(ch)) {
                    mal.put(ch, mal.get(ch) - 1);
                    if (mal.get(ch) == 0) count--;
                }
                j++;
            }
            while (i < j && count == 0) {
                if (f == 0 || j - i < rep.length()) {
                    rep = s.substring(i, j);
                    f = 1;
                }
                char ch = s.charAt(i);
                if (mal.containsKey(ch)) {
                    mal.put(ch, mal.get(ch) + 1);
                    if (mal.get(ch) > 0) count++;
                }
                i++;
            }
        }
        return rep;
    }
}