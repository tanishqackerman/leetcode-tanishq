import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        final int n = s.length(), m = words[0].length(), k = words.length;
        final HashMap<String, Integer> mal = new HashMap<>();
        for (final String str: words) mal.put(str, mal.getOrDefault(str, 0) + 1);
        final List<Integer> rep = new ArrayList<>();
        for (int i = 0; i < n - m * k + 1; i++) {
            final HashMap<String, Integer> temp = new HashMap<>();
            int j = 0;
            while (j < k) {
                final String word = s.substring(i + j * m, i + (j + 1) * m);
                if (mal.containsKey(word)) {
                    temp.put(word, temp.getOrDefault(word, 0) + 1);
                    if (temp.get(word) > mal.getOrDefault(word, 0)) break;
                } else break;
                j++;
            }
            if (j == k) rep.add(i);
        }
        return rep;
    }
}