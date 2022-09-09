package cn_solution

import base.TreeNode

fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
    return when {
        root1 == null -> root2
        root2 == null -> root1
        else -> TreeNode(root1.`val` + root2.`val`).apply {
            left = mergeTrees(root1.left, root2.left)
            right = mergeTrees(root1.right, root2.right)
        }
    }
}