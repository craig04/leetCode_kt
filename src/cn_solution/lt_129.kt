package cn_solution

import base.TreeNode

fun sumNumbers(root: TreeNode?): Int {
    val builder = StringBuilder()
    var result = 0
    fun dfs(node: TreeNode?) {
        node ?: return
        val len = builder.length
        builder.append(node.`val`)
        if (node.left == null && node.right == null) {
            result += builder.toString().toInt()
        } else {
            dfs(node.left)
            dfs(node.right)
        }
        builder.setLength(len)
    }
    dfs(root)
    return result
}