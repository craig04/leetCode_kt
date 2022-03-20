package cn_solution

import base.TreeNode

fun invertTree(root: TreeNode?): TreeNode? {
    return root?.let {
        TreeNode(it.`val`).apply {
            left = invertTree(it.right)
            right = invertTree(it.left)
        }
    }
}