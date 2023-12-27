class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] cache = new boolean[s.length() + 1];
        cache[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (String w: wordDict) {
                if (i + w.length() <= s.length() && s.substring(i, i + w.length()).equals(w)) cache[i] = cache[i + w.length()];
                if (cache[i]) break;
            }
        }
        return cache[0];
    }
}