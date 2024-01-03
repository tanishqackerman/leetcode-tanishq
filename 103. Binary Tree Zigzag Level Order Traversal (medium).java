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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rep = new ArrayList<>();
        if (root == null) return rep;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int f = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> el = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tn = q.poll();
                if (tn.left != null) q.offer(tn.left);
                if (tn.right != null) q.offer(tn.right);
                el.add(tn.val);
            }
            if (f == 1) {
                Collections.reverse(el);
                f = 0;
            } else f = 1;
            rep.add(el);
        }
        return rep;
    }
}