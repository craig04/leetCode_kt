package cn_solution

import base.TreeNode

fun binaryTreePaths(root: TreeNode?): List<String> {
    val result = ArrayList<String>()
    val builder = StringBuilder()
    fun dfs(node: TreeNode?) {
        node ?: return
        val len = builder.length
        builder.append(node.`val`)
        if (node.left == null && node.right == null) {
            result.add(builder.toString())
        } else {
            builder.append("->")
            dfs(node.left)
            dfs(node.right)
        }
        builder.setLength(len)
    }
    dfs(root)
    return result
}