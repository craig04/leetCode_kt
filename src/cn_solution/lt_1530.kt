package cn_solution

import base.TreeNode

fun countPairs(root: TreeNode?, distance: Int): Int {
    val default = IntArray(distance + 1)
    var ans = 0
    fun TreeNode?.dfs(): IntArray {
        this ?: return default
        val res = IntArray(distance + 1)
        if (left == null && right == null) {
            res[1] = 1
            return res
        }
        val x = left.dfs()
        val y = right.dfs()
        for (i in 1 until distance)
            for (j in 1..distance - i)
                ans += x[i] * y[j]
        for (i in 1 until distance)
            res[i + 1] += x[i] + y[i]
        return res
    }
    root.dfs()
    return ans
}