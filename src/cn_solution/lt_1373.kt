package cn_solution

import base.TreeNode

fun maxSumBST(root: TreeNode?): Int {
    var result = 0
    val invalid = intArrayOf(0, 0, 0, 0)
    val leaf = intArrayOf(Int.MAX_VALUE, Int.MIN_VALUE, 0, 1)
    fun TreeNode?.dfs(): IntArray {
        this ?: return leaf
        val l = left.dfs()
        val r = right.dfs()
        if (l[3] == 0 || l[1] >= `val` || r[3] == 0 || r[0] <= `val`) {
            return invalid
        }
        val sum = `val` + l[2] + r[2]
        result = maxOf(result, sum)
        return intArrayOf(minOf(`val`, l[0]), maxOf(`val`, r[1]), sum, 1)

    }
    root.dfs()
    return result
}