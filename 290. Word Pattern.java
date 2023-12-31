import java.util.*;

class Solution {
    public boolean wordPattern(String s, String ta) {
        String[] t = ta.split(" ");
        if (s.length() != t.length) return false;
        HashMap<Character, String> sm = new HashMap<>();
        HashMap<String, Character> tm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!sm.containsKey(s.charAt(i)) && !tm.containsKey(t[i])) {
                sm.put(s.charAt(i), t[i]);
                tm.put(t[i], s.charAt(i));
            } else if (sm.containsKey(s.charAt(i)) && !tm.containsKey(t[i]) || !sm.containsKey(s.charAt(i)) && tm.containsKey(t[i])) {
                return false;
            } else if (sm.containsKey(s.charAt(i)) && tm.containsKey(t[i])) {
                if (s.charAt(i) != tm.get(t[i]) || !t[i].equals(sm.get(s.charAt(i)))) {
                    return false;
                }
            }
        }
        return true;
    }
}