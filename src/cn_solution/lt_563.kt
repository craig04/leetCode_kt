package cn_solution

import base.TreeNode

fun findTilt(root: TreeNode?): Int {
    var result = 0
    fun findTilt(root: TreeNode?): Int {
        root ?: return 0
        val left = findTilt(root.left)
        val right = findTilt(root.right)
        result += Math.abs(left - right)
        return left + right + root.`val`
    }
    findTilt(root)
    return result
}