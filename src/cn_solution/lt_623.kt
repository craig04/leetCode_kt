package cn_solution

import base.TreeNode

fun addOneRow(root: TreeNode?, `val`: Int, depth: Int): TreeNode? {
    return when {
        root == null -> null
        depth == 1 -> TreeNode(`val`, root, null)
        depth == 2 -> root.apply {
            left = TreeNode(`val`, left, null)
            right = TreeNode(`val`, null, right)
        }

        else -> root.apply {
            left = addOneRow(left, `val`, depth - 1)
            right = addOneRow(right, `val`, depth - 1)
        }
    }
}
