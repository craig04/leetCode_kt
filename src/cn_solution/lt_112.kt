package cn_solution

import base.TreeNode

fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    root ?: return false
    val sum = targetSum - root.`val`
    if (root.left == null && root.right == null) {
        return sum == 0
    }
    return hasPathSum(root.left, sum) || hasPathSum(root.right, sum)
}