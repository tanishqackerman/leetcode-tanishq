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

    public void inorder(TreeNode root, int[] rep) {
        if (root == null) return;
        inorder(root.left, rep);
        rep[0]++;
        inorder(root.right, rep);
    }

    public int countNodes(TreeNode root) {
        int rep[] = new int[1];
        inorder(root, rep);
        return rep[0];
    }
}