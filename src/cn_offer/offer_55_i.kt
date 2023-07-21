package cn_offer

import base.TreeNode

fun maxDepth(root: TreeNode?): Int {
    return root?.run { maxOf(maxDepth(left), maxDepth(right)) + 1 } ?: 0
}