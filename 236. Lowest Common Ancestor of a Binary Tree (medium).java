import java.util.*;

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

    public boolean getPath(TreeNode root, TreeNode p, List<TreeNode> el) {
        if (root == null) return false;
        el.add(root);
        if (root.val == p.val) return true;
        if (getPath(root.left, p, el) || getPath(root.right, p, el)) {
            return true;
        }
        el.remove(el.size() - 1);
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> el1 = new ArrayList<>();
        List<TreeNode> el2 = new ArrayList<>();
        getPath(root, p, el1);
        getPath(root, q, el2);
        for (int i = Math.min(el1.size(), el2.size()) - 1; i >= 0 ; i--) {
            if (el1.get(i) == el2.get(i)) return el1.get(i);
        }
        return root;
    }
}