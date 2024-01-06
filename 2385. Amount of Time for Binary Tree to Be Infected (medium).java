import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int amountOfTime(TreeNode root, int target) {
        final HashMap<TreeNode, TreeNode> mal = new HashMap<>();
        final Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        TreeNode t = root;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.val == target) t = node;
                if (node.left != null) {
                    mal.put(node.left, node);
                    q.offer(node.left);
                }
                if (node.right != null) {
                    mal.put(node.right, node);
                    q.offer(node.right);
                }
            }
        }
        int level = 0;
        final Queue<Pair> queue = new ArrayDeque<>();
        final HashMap<TreeNode, Boolean> vis = new HashMap<>();
        queue.offer(new Pair(t, 0));
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair p = queue.poll();
                TreeNode node = p.node;
                vis.put(node, true);
                int l = p.l;
                level = Math.max(level, l);
                if (node.left != null && !vis.containsKey(node.left)) {
                    queue.offer(new Pair(node.left, l + 1));
                }
                if (node.right != null && !vis.containsKey(node.right)) {
                    queue.offer(new Pair(node.right, l + 1));
                }
                if (mal.containsKey(node) && !vis.containsKey(mal.get(node))) {
                    queue.offer(new Pair(mal.get(node), l + 1));
                }
            }
        }
        return level;
    }
}

class Pair {
    TreeNode node;
    int l;
    
    public Pair(TreeNode node, int l) {
        this.node = node;
        this.l = l;
    }
}