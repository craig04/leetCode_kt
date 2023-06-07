package cn_interview;

import base.TreeNode;

class Solution_0408 {

    private TreeNode result;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return result;
    }

    private int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return 0;
        int left = dfs(root.left, p, q);
        int right = dfs(root.right, p, q);
        int cur = (root == p || root == q) ? 1 : 0;
        if (left + right + cur == 2) {
            result = root;
        }
        return Math.min(1, left + right + cur);
    }
}