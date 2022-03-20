package cn_solution

import base.TreeNode

private fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    var result: TreeNode? = null
    fun dfs(node: TreeNode?): Int {
        node ?: return 0
        val l = dfs(node.left)
        val r = dfs(node.right)
        val c = if (node == p || node == q) 1 else 0
        if (l + r + c == 2) result = node
        return minOf(1, l + r + c)
    }
    dfs(root)
    return result
}