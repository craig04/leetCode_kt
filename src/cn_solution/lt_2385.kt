package cn_solution

import base.TreeNode

fun amountOfTime(root: TreeNode?, start: Int): Int {
    val adj = HashMap<Int, ArrayList<Int>>()

    fun TreeNode?.dfs(p: TreeNode?) {
        this ?: return
        val list = ArrayList<Int>()
        adj[`val`] = list
        fun connect(other: TreeNode?) {
            if (other != null)
                list.add(other.`val`)
        }
        connect(p)
        connect(left)
        connect(right)
        left.dfs(this)
        right.dfs(this)
    }
    root?.dfs(null)
    fun dfs(u: Int, p: Int): Int {
        var result = 0
        for (v in adj[u] ?: return 1)
            if (v != p)
                result = maxOf(result, dfs(v, u))
        return result + 1
    }
    return dfs(start, -1) - 1
}