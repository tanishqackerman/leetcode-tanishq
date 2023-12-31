class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, rep = 1;
        while (j < n) {
            if (set.contains(s.charAt(j))) {
                while (set.contains(s.charAt(j))) {
                    set.remove(s.charAt(i++));
                }
                set.add(s.charAt(j++));
            } else {
                set.add(s.charAt(j++));
                rep = Math.max(rep, set.size());
            }
        }
        return rep;
    }
}