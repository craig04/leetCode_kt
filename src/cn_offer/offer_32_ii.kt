package cn_offer

import base.TreeNode

private fun levelOrder(root: TreeNode?): List<List<Int>> {
    val q = ArrayDeque<TreeNode>()
    val result = ArrayList<List<Int>>()
    fun TreeNode.enqueue() = q.add(this)
    root?.enqueue()
    while (q.isNotEmpty()) {
        val list = ArrayList<Int>()
        repeat(q.size) {
            q.removeFirst().run {
                list.add(`val`)
                left?.enqueue()
                right?.enqueue()
            }
        }
        result.add(list)
    }
    return result
}