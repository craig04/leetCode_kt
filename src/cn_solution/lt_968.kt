package cn_solution

import base.TreeNode

fun minCameraCover(root: TreeNode?): Int {
    val dp = Array(4) { HashMap<TreeNode, Int>() }
    fun TreeNode?.dfs(curr: Int): Int {
        this ?: return 0
        return dp[curr].getOrPut(this) {
            var ans = 1 + left.dfs(2) + right.dfs(2)
            if (curr and 1 == 0) {
                if (curr and 2 != 0) {
                    ans = minOf(ans, left.dfs(0) + right.dfs(0))
                } else {
                    left?.let { ans = minOf(ans, it.dfs(1) + right.dfs(0)) }
                    right?.let { ans = minOf(ans, left.dfs(0) + it.dfs(1)) }
                }
            }
            ans
        }
    }
    return root.dfs(0)
}