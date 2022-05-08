package cn_solution

import base.TreeNode

fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {
    fun build(root: TreeNode?): ArrayList<Int> {
        val dest = ArrayList<Int>()
        fun TreeNode?.flatten() {
            this ?: return
            left.flatten()
            dest.add(`val`)
            right.flatten()
        }
        root.flatten()
        return dest
    }

    val l1 = build(root1)
    val l2 = build(root2)
    var p1 = 0
    var p2 = 0
    val s1 = l1.size
    val s2 = l2.size
    val result = ArrayList<Int>(s1 + s2)
    while (p1 != s1 || p2 != s2) {
        when {
            p1 == s1 -> result.add(l2[p2++])
            p2 == s2 -> result.add(l1[p1++])
            l1[p1] < l2[p2] -> result.add(l1[p1++])
            else -> result.add(l2[p2++])
        }
    }
    return result
}