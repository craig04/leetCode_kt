package cn_solution

import base.TreeNode

fun balanceBST(root: TreeNode?): TreeNode? {
    val list = ArrayList<Int>()
    fun TreeNode?.dfs() {
        this ?: return
        left.dfs()
        list.add(`val`)
        right.dfs()
    }
    root?.dfs()
    fun balance(s: Int, e: Int): TreeNode? {
        if (s == e)
            return null
        val m = (s + e) / 2
        val res = TreeNode(list[m])
        res.left = balance(s, m)
        res.right = balance(m + 1, e)
        return res
    }
    return balance(0, list.size)
}