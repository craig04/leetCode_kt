package cn_solution

import base.TreeNode

fun maxPathSum(root: TreeNode?): Int {
    var result = Int.MIN_VALUE
    fun dfs(node: TreeNode?): Int {
        node ?: return 0
        val left = maxOf(0, dfs(node.left))
        val right = maxOf(0, dfs(node.right))
        result = maxOf(result, node.`val` + left + right)
        return maxOf(left, right) + node.`val`
    }
    dfs(root)
    return result
}