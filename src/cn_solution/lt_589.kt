package cn_solution

import base.Node

fun preorder(root: Node?): List<Int> {
    root ?: return emptyList()
    val q = arrayListOf(root)
    val result = ArrayList<Int>()
    while (q.isNotEmpty()) {
        val n = q.removeAt(q.lastIndex)
        result.add(n.`val`)
        n.children.asReversed().forEach {
            it?.let { q.add(it) }
        }
    }
    return result
}