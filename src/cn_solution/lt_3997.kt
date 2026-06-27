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
fun countDominantNodes(root: TreeNode?): Int {
    var ans = 0
    fun TreeNode?.dfs(): Int {
        this ?: return 0
        val sub = maxOf(left.dfs(), right.dfs())
        if (`val` >= sub)
            ans++
        return maxOf(`val`, sub)
    }
    root.dfs()
    return ans
}