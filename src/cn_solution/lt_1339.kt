package cn_solution

import base.TreeNode

fun maxProduct(root: TreeNode?): Int {
    val sums = ArrayList<Int>()
    fun TreeNode?.dfs(): Int {
        this ?: return 0
        val l = left.dfs()
        val r = right.dfs()
        return (`val` + l + r).apply(sums::add)
    }

    val all = root.dfs()
    return sums.maxOf { 1L * (all - it) * it }.mod(1000_000_007)
}