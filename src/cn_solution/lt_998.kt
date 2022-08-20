package cn_solution

import base.TreeNode

fun insertIntoMaxTree(root: TreeNode?, `val`: Int): TreeNode? {
    return if (root == null || root.`val` < `val`)
        TreeNode(`val`).apply { left = root }
    else
        root.apply { right = insertIntoMaxTree(right, `val`) }
}