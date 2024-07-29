package cn_solution

import base.TreeNode

fun treeQueries(root: TreeNode?, queries: IntArray): IntArray {
    val info = HashMap<Int, Long>()
    val layer = ArrayList<IntArray>()
    fun TreeNode?.dfs(depth: Int): Int {
        this ?: return -1
        if (layer.size == depth)
            layer.add(IntArray(2) { -1 })
        val height = maxOf(left.dfs(depth + 1), right.dfs(depth + 1)) + 1
        info[`val`] = depth.toLong().shl(32) + height
        val a = layer[depth]
        if (height > a[0]) {
            a[1] = a[0]
            a[0] = height
        } else
            a[1] = maxOf(a[1], height)
        return height
    }
    root?.dfs(0)
    return IntArray(queries.size) {
        val value = info[queries[it]]!!
        val depth = value.shr(32).toInt()
        val height = value.and(0xffffffff).toInt()
        val a = layer[depth]
        depth + if (height != a[0]) a[0] else a[1]
    }
}