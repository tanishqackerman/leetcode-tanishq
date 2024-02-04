import java.util.*;

class Solution {

    public void dfs(int i, List<List<Integer>> adj, boolean[] vis) {
        vis[i] = true;
        for (Integer node: adj.get(i)) {
            if (!vis[node]) dfs(node, adj, vis);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[n];
        int rep = 0;
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis);
                rep++;
            }
        }
        return rep;
    }
}