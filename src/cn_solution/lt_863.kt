package cn_solution

import base.TreeNode

fun distanceK(root: TreeNode?, target: TreeNode?, k: Int): List<Int> {
    val map = HashMap<TreeNode, TreeNode?>()
    fun TreeNode.dfs(fa: TreeNode?) {
        map[this] = fa
        left?.dfs(this)
        right?.dfs(this)
    }
    root?.dfs(null)
    val ans = ArrayList<Int>()
    fun TreeNode?.search(dist: Int, from: TreeNode?) {
        this ?: return
        if (dist == k) {
            ans.add(`val`)
            return
        }
        fun test(next: TreeNode?) {
            if (next != from)
                next?.search(dist + 1, this)
        }
        test(left)
        test(right)
        test(map[this])
    }
    target.search(0, null)
    return ans
}
