package cn_solution;

import base.TreeNode;

class Solution {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned == null || original == target) {
            return cloned;
        }
        TreeNode result = getTargetCopy(original.left, cloned.left, target);
        return result != null ? result : getTargetCopy(original.right, cloned.right, target);
    }
}