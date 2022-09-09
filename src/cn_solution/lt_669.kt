package cn_solution

import base.TreeNode

fun trimBST(root: TreeNode?, low: Int, high: Int): TreeNode? {
    return when {
        root == null -> null
        root.`val` < low -> trimBST(root.right, low, high)
        root.`val` > high -> trimBST(root.left, low, high)
        else -> root.apply {
            left = trimBST(left, low, high)
            right = trimBST(right, low, high)
        }
    }
}