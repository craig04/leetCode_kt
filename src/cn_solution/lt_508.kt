package cn_solution

import base.TreeNode

fun findFrequentTreeSum(root: TreeNode?): IntArray {
    val map = HashMap<Int, Int>()
    fun TreeNode.dfs(): Int {
        val res = `val` + (left?.dfs() ?: 0) + (right?.dfs() ?: 0)
        map.merge(res, 1, Int::plus)
        return res
    }
    root?.dfs()
    var cnt = 0
    val num = ArrayList<Int>()
    for ((k, v) in map) {
        if (v > cnt) {
            cnt = v
            num.clear()
        }
        if (v == cnt)
            num.add(k)
    }
    return num.toIntArray()
}