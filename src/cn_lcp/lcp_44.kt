package cn_lcp

import base.TreeNode

fun numColor(root: TreeNode?): Int {
    val color = HashSet<Int>()
    fun TreeNode.dfs() {
        color.add(`val`)
        left?.dfs()
        right?.dfs()
    }
    root?.dfs()
    return color.size
}