package cn_solution

import base.TreeNode

fun maxProduct(root: TreeNode?): Int {
    fun TreeNode?.dfs(f: ((Int) -> Unit)?): Int {
        this ?: return 0
        val sum = `val` + left.dfs(f) + right.dfs(f)
        f?.invoke(sum)
        return sum
    }

    var ans = 0L
    val sum = root.dfs(null) + 0L
    root.dfs { ans = maxOf(ans, (sum - it) * it) }
    return ans.mod(1000000007)
}