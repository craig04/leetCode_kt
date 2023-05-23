package cn_interview

import base.TreeNode

/**
 * Solution using inorder traversal
 */
fun convertBiNode(root: TreeNode?): TreeNode? {
    val head = TreeNode(0)
    var last = head
    fun TreeNode?.dfs(): Unit? = this?.let {
        left.dfs()
        left = null
        last.right = this
        last = this
        right.dfs()
    }
    root?.dfs()
    return head.right
}

/**
 * Solution using recursion
 */
fun convertBiNode_recursion(root: TreeNode?): TreeNode? {
    fun TreeNode.convert(): Pair<TreeNode, TreeNode> {
        var head = this
        var tail = this
        left?.let {
            val (h, t) = it.convert()
            head = h
            t.right = this
            left = null
        }
        right?.let {
            val (h, t) = it.convert()
            tail = t
            right = h
        }
        return Pair(head, tail)
    }
    return root?.convert()?.first
}