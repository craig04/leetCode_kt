package cn_solution

import base.TreeNode

fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
    root ?: return TreeNode(`val`)
    if (`val` < root.`val`)
        root.left = insertIntoBST(root.left, `val`)
    else
        root.right = insertIntoBST(root.right, `val`)
    return root
}
