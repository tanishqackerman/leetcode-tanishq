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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        TreeMap<Integer, Integer> mal = new TreeMap<>();
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root, 0));
        mal.put(0, root.val);
        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode node = p.node;
            int row = p.row;
            mal.put(row, node.val);
            if (node.left != null) q.offer(new Pair(node.left, row + 1));
            if (node.right != null) q.offer(new Pair(node.right, row + 1));
        }
        return new ArrayList<>(mal.values());
    }
}

class Pair {
    TreeNode node;
    int row;
    
    public Pair(TreeNode node, int row) {
        this.node = node;
        this.row = row;
    }
}