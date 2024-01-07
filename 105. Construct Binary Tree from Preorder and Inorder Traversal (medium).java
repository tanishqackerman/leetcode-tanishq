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
    
    public TreeNode build(int[] pre, int pres, int pree, int[] in, int ins, int ine, HashMap<Integer, Integer> mal) {
        if (pres > pree || ins > ine) return null;
        TreeNode root = new TreeNode(pre[pres]);
        root.left = build(pre, pres + 1, pres + mal.get(pre[pres]) - ins, in, ins, mal.get(pre[pres]) - 1, mal);
        root.right = build(pre, pres + mal.get(pre[pres]) - ins + 1, pree, in, mal.get(pre[pres]) + 1, ine, mal);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> mal = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) mal.put(inorder[i], i);
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length, mal);
    }
}