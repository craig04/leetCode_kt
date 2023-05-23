package cn_interview;

import base.TreeNode;

class Solution_0406 {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        if (p.right != null) {
            succ = p.right;
            while (succ.left != null) {
                succ = succ.left;
            }
            return succ;
        }
        TreeNode temp = root;
        while (temp != null) {
            if (temp.val > p.val) {
                succ = temp;
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return succ;
    }
}