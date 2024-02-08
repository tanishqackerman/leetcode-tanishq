import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] in = new int[numCourses];
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        for (int i = 0; i < numCourses; i++) {
            for (Integer node: adj.get(i)) {
                in[node]++;
            }
        }
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0) {
                q.offer(i);
            }
        }
        List<Integer> rep = new ArrayList<>();
        if (q.isEmpty()) return false;
        while (!q.isEmpty()) {
            Integer t = q.poll();
            rep.add(t);
            for (Integer node: adj.get(t)) {
                in[node]--;
                if (in[node] == 0) q.offer(node);
            }
        }
        return rep.size() == numCourses;
    }
}