package cn_solution

import base.TreeNode

fun printTree(root: TreeNode?): List<List<String>> {
    var height = 0
    fun findHeight(root: TreeNode?, h: Int) {
        root ?: return
        height = maxOf(height, h)
        findHeight(root.left, h + 1)
        findHeight(root.right, h + 1)
    }
    findHeight(root, 1)
    val cols = 1.shl(height) - 1
    val result = Array(height) { Array(cols) { "" } }
    fun update(root: TreeNode?, l: Int, r: Int, h: Int) {
        root ?: return
        val m = (l + r).shr(1)
        result[h][m] = root.`val`.toString()
        update(root.left, l, m, h + 1)
        update(root.right, m + 1, r, h + 1)
    }
    update(root, 0, cols, 0)
    return result.map { it.asList() }
}