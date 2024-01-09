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

    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val >= q.val && root.val <= p.val || root.val <= q.val && root.val >= p.val) return root;
        if (root.val > q.val && root.val > p.val) return lca(root.left, p, q);
        else return lca (root.right, p, q);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root, p, q);
    }
}