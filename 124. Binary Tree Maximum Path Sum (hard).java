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

    public int maxPath(TreeNode root, int[] rep) {
        if (root == null) return 0;
        int lh = maxPath(root.left, rep);
        int rh = maxPath(root.right, rep);
        rep[0] = Math.max(rep[0], root.val + lh + rh);
        rep[0] = Math.max(rep[0], root.val + rh);
        rep[0] = Math.max(rep[0], root.val + lh);
        rep[0] = Math.max(rep[0], root.val);
        return root.val + Math.max(0, Math.max(lh, rh));
    }

    public int maxPathSum(TreeNode root) {
        int[] rep = new int[1];
        rep[0] = root.val;
        maxPath(root, rep);
        return rep[0];
    }
}