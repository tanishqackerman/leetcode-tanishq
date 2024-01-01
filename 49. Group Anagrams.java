import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final HashMap<String, List<String>> mal = new HashMap<>();
        for (String str: strs) {
            final char[] s = str.toCharArray();
            Arrays.sort(s);
            final String string = new String(s);
            if (mal.containsKey(string)) mal.get(string).add(str);
            else mal.put(string, new ArrayList<>(Arrays.asList(str)));
        }
        return new ArrayList<>(mal.values());
    }
}