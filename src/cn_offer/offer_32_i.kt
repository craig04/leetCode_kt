package cn_offer

import base.TreeNode

private fun levelOrder(root: TreeNode?): IntArray {
    val q = ArrayDeque<TreeNode>()
    val list = ArrayList<Int>()
    fun TreeNode.add() = q.add(this)
    root?.add()
    while (q.isNotEmpty()) {
        q.removeFirst().run {
            list.add(`val`)
            left?.add()
            right?.add()
        }
    }
    return IntArray(list.size) { list[it] }
}