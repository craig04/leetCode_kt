package cn_solution

import base.TreeNode

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
fun bstFromPreorder(preorder: IntArray): TreeNode? {
    fun build(start: Int, end: Int): TreeNode? {
        if (start >= end)
            return null
        val root = TreeNode(preorder[start])
        var i = start + 1
        while (i != end && preorder[i] < root.`val`)
            i++
        root.left = build(start + 1, i)
        root.right = build(i, end)
        return root
    }
    return build(0, preorder.size)
}