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
class BSTIterator {

    int ptr = -1;
    List<Integer> in;

    public BSTIterator(TreeNode root) {
        in = new ArrayList<>();
        inorder(root, in);
    }

    public void inorder(TreeNode root, List<Integer> in) {
        if (root == null) return;
        inorder(root.left, in);
        in.add(root.val);
        inorder(root.right, in);
    }
    
    public int next() {
        return in.get(++ptr);
    }
    
    public boolean hasNext() {
        if (ptr < in.size() - 1) return true;
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */