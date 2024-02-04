import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        for (int k = 0; k < graph.length; k++) {
            if (color[k] != 0) continue;
            q.offer(k);
            color[k] = 1;
            while (!q.isEmpty()) {
                Integer i = q.poll();
                for (int j = 0; j < graph[i].length; j++) {
                    if (color[graph[i][j]] == 0) {
                        color[graph[i][j]] = color[i] == 1 ? 2 : 1;
                        q.offer(graph[i][j]);
                    } else if (color[graph[i][j]] == color[i] && color[graph[i][j]] != 0) return false;
                }
            }
        }
        return true;
    }
}