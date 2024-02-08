import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] in = new int[numCourses];
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
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
        int[] rep = new int[numCourses];
        int i = 0;
        while (!q.isEmpty()) {
            Integer t = q.poll();
            rep[i++] = t;
            for (Integer node: adj.get(t)) {
                in[node]--;
                if (in[node] == 0) q.offer(node);
            }
        }
        return i == numCourses ? rep : new int[] {};
    }
}