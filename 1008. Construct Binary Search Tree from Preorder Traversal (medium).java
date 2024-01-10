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

    public TreeNode createBst(int[] pre, int ub, int[] i) {
        if (i[0] == pre.length || pre[i[0]] > ub) return null;
        TreeNode root = new TreeNode(pre[i[0]++]);
        root.left = createBst(pre, root.val, i);
        root.right = createBst(pre, ub, i);
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return createBst(preorder, Integer.MAX_VALUE, new int[] {0});
    }
}