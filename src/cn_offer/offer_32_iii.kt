package cn_offer

import base.TreeNode

private fun levelOrder(root: TreeNode?): List<List<Int>> {
    val q = ArrayDeque<TreeNode>()
    val result = ArrayList<List<Int>>()
    var reversed = false
    fun TreeNode.enqueue() = q.add(this)
    root?.enqueue()
    while (q.isNotEmpty()) {
        var list = mutableListOf<Int>()
        repeat(q.size) {
            q.removeFirst().run {
                list.add(`val`)
                left?.enqueue()
                right?.enqueue()
            }
        }
        if (reversed)
            list = list.asReversed()
        reversed = !reversed
        result.add(list)
    }
    return result
}