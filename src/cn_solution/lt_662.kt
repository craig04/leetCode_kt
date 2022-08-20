package cn_solution

import base.TreeNode

fun widthOfBinaryTree(root: TreeNode?): Int {
    val leftmost = ArrayList<Int>()
    var result = 0
    fun dfs(root: TreeNode?, layer: Int, index: Int) {
        root ?: return
        if (leftmost.size == layer) {
            leftmost.add(index)
        }
        result = maxOf(result, index - leftmost[layer] + 1)
        dfs(root.left, layer + 1, index * 2)
        dfs(root.right, layer + 1, index * 2 + 1)
    }
    dfs(root, 0, 1)
    return result
}