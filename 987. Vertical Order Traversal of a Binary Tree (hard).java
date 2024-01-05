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

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> rep = new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new ArrayDeque<>();
        q.offer(new Tuple(root, 0, 0));
        while (!q.isEmpty()) {
            Tuple t = q.poll();
            TreeNode node = t.node;
            int row = t.row;
            int col = t.col;
            if (!map.containsKey(col)) {
                map.put(col, new TreeMap<>());
            }
            if (!map.get(col).containsKey(row)) {
                map.get(col).put(row, new PriorityQueue<>());
            }
            map.get(col).get(row).offer(node.val);
            if (node.left != null) {
                q.offer(new Tuple(node.left, row + 1, col - 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, row + 1, col + 1));
            }
        }
        for (Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> set: map.entrySet()) {
            List<Integer> el = new ArrayList<>();
            for (Map.Entry<Integer, PriorityQueue<Integer>> s: set.getValue().entrySet()) {
                while (!s.getValue().isEmpty()) {
                    el.add(s.getValue().poll());
                }
            }
            rep.add(el);
        }
        return rep;
    }
}

class Tuple {
    TreeNode node;
    int row, col;

    public Tuple(TreeNode node, int row, int col) {
        this.row = row;
        this.col = col;
        this.node = node;
    }
}