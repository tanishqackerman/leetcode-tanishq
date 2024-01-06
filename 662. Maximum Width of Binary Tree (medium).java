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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new ArrayDeque<>();
        int rep = 1;
        q.offer(new Pair(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int k = 0; k < size; k++) {
                Pair p = q.poll();
                TreeNode node = p.node;
                int i = p.i;
                min = Math.min(min, i);
                max = Math.max(max, i);
                i -= min;
                if (node.left != null) q.offer(new Pair(node.left, 2 * i + 1));
                if (node.right != null) q.offer(new Pair(node.right, 2 * i + 2));
            }
            rep = Math.max(rep, max - min + 1);
        }
        return rep;
    }
}

class Pair {
    TreeNode node;
    int i;

    public Pair(TreeNode node, int i) {
        this.node = node;
        this.i = i;
    }
}