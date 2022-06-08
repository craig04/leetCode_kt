package cn_interview;

import base.TreeNode;

class Solution {

    private TreeNode last = null;
    private TreeNode result = null;
    private TreeNode target = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        target = p;
        traverse(root);
        return result;
    }

    private void traverse(TreeNode root) {
        if (root == null)
            return;
        traverse(root.left);
        if (last == target)
            result = root;
        last = root;
        traverse(root.right);
    }
}
