package cn_offer

import base.TreeNode

fun rightSideView(root: TreeNode?): List<Int> {
    val result = ArrayList<Int>()
    var cur = ArrayList<TreeNode>()
    root?.let { cur.add(it) }
    while (cur.isNotEmpty()) {
        val next = ArrayList<TreeNode>()
        cur.forEach {
            it.left?.run { next.add(this) }
            it.right?.run { next.add(this) }
        }
        result.add(cur.last().`val`)
        cur = next
    }
    return result
}