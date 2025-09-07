package cn_solution

import base.TreeNode

fun averageOfSubtree(root: TreeNode?): Int {
    var ans = 0
    val empty = IntArray(2)
    fun TreeNode?.dfs(): IntArray {
        this ?: return empty
        val res = intArrayOf(`val`, 1)
        fun add(it: IntArray) {
            res[0] += it[0]
            res[1] += it[1]
        }
        add(left.dfs())
        add(right.dfs())
        if (res[0] / res[1] == `val`)
            ans++
        return res
    }
    root.dfs()
    return ans
}