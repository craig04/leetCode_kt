package cn_offer

import base.TreeNode

fun mirrorTree(root: TreeNode?): TreeNode? {
    return root?.let {
        TreeNode(it.`val`).apply {
            left = mirrorTree(it.right)
            right = mirrorTree(it.left)
        }
    }
}