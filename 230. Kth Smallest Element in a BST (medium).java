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

    public void validate(TreeNode root, List<Integer> el) {
        if (root == null) return;
        validate(root.left, el);
        el.add(root.val);
        validate(root.right, el);
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> el = new ArrayList<>();
        validate(root, el);
        return el.get(k - 1);
    }
}