package cn_lcp

import base.TreeNode
import java.util.*

fun getNumber(root: TreeNode?, ops: Array<IntArray>): Int {
    val set = TreeSet<Int>()
    fun TreeNode?.dfs() {
        this ?: return
        set.add(`val`)
        left.dfs()
        right.dfs()
    }
    root.dfs()
    var ans = 0
    for (i in ops.indices.reversed()) {
        val (type, x, y) = ops[i]
        while (true) {
            val z = set.ceiling(x)
            if (z == null || z > y)
                break
            ans += type
            set.remove(z)
        }
    }
    return ans
}