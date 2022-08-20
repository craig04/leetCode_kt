package cn_solution

import base.TreeNode

fun deepestLeavesSum(root: TreeNode?): Int {
    var layer = 0
    var result = 0
    fun dfs(node: TreeNode?, l: Int) {
        if (node == null) return
        dfs(node.left, l + 1)
        dfs(node.right, l + 1)
        if (l < layer) return
        if (l > layer) {
            layer = l
            result = 0
        }
        result += node.`val`
    }
    dfs(root, 0)
    return result
}