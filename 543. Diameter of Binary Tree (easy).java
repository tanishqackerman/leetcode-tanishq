class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int dia(TreeNode root, int[] rep) {
        if (root == null) return 0;
        int lh = dia(root.left, rep);
        int rh = dia(root.right, rep);
        rep[0] = Math.max(rep[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] rep = new int[1];
        dia(root, rep);
        return rep[0];
    }
}