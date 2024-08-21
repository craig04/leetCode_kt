package cn_lcp

import base.TreeNode

fun expandBinaryTree(root: TreeNode?): TreeNode? {
    fun TreeNode.expand(): TreeNode {
        left = left?.let { TreeNode(-1).apply { left = it.expand() } }
        right = right?.let { TreeNode(-1).apply { right = it.expand() } }
        return this
    }
    return root?.expand()
}