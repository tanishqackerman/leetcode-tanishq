import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rep = new ArrayList<>();
        rep.add(new ArrayList<>());
        rep.get(0).add(1);
        for (int i = 0; i < numRows - 1; i++) {
            List<Integer> el = new ArrayList<>();
            el.add(1);
            for (int j = 0; j < rep.get(i).size() - 1; j++) {
                el.add(rep.get(i).get(j) + rep.get(i).get(j + 1));
            }
            el.add(1);
            rep.add(el);
        }
        return rep;
    }
}