package cn_solution

import base.TreeNode

fun kthLargestLevelSum(root: TreeNode?, k: Int): Long {
    val sum = ArrayList<Long>()
    fun TreeNode?.dfs(level: Int) {
        this ?: return
        if (sum.size <= level)
            sum.add(0)
        sum[level] = sum[level] + `val`
        left.dfs(level + 1)
        right.dfs(level + 1)
    }
    sum.sort()
    val idx = sum.size - k
    return if (idx >= 0) sum[idx] else -1
}