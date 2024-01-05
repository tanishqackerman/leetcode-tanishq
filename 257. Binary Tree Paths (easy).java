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

    public void getPath(TreeNode root, String el, List<String> rep) {
        if (root.left == null && root.right == null) rep.add(el + root.val);
        if (root.left != null) getPath(root.left, el + root.val + "->", rep);
        if (root.right != null) getPath(root.right, el + root.val + "->", rep);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rep = new ArrayList<>();
        getPath(root, "", rep);
        return rep;
    }
}