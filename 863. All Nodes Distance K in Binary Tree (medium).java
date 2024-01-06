import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> mal = new HashMap<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
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
        List<Integer> rep = new ArrayList<>();
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(target, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            int f = 0;
            for (int i = 0; i < size; i++) {
                Pair p = queue.poll();
                TreeNode t = p.node;
                int d = p.d;
                if (d == k) {
                    rep.add(t.val);
                    f = 1;
                }
                if (t.left != null) {
                    queue.offer(new Pair(t.left, d + 1));
                    mal.remove(t.left);
                }
                if (t.right != null) {
                    queue.offer(new Pair(t.right, d + 1));
                    mal.remove(t.right);
                }
                if (mal.containsKey(t)) {
                    queue.offer(new Pair(mal.get(t), d + 1));
                    if (mal.get(t).left == t) mal.get(t).left = null;
                    if (mal.get(t).right == t) mal.get(t).right = null;
                }
            }
            if (f == 1) break;
        }
        return rep;
    }
}

class Pair {
    TreeNode node;
    int d;

    public Pair(TreeNode node, int d) {
        this.node = node;
        this.d = d;
    }
}