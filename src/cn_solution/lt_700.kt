package cn_solution

import base.TreeNode

fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
    return when {
        root == null -> null
        root.`val` < `val` -> searchBST(root.right, `val`)
        root.`val` > `val` -> searchBST(root.left, `val`)
        else -> root
    }
}