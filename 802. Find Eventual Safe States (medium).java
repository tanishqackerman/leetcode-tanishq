import java.util.*;

class Solution {

    public boolean dfs(int i, boolean[] vis, boolean[] pathVis, int[][] graph) {
        vis[i] = true;
        pathVis[i] = true;
        for (int j = 0; j < graph[i].length; j++) {
            if (!vis[graph[i][j]]) {
                if (dfs(graph[i][j], vis, pathVis, graph)) return true;
            } else if (pathVis[graph[i][j]]) return true;
        }
        pathVis[i] = false;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> rep = new ArrayList<>();
        boolean[] vis = new boolean[graph.length];
        boolean[] pathVis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!dfs(i, vis, pathVis, graph)) rep.add(i);
        }
        return rep;
    }
}