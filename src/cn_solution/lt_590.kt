package cn_solution

import base.Node

fun postorder(root: Node?): List<Int> {
    root ?: return emptyList()
    class Helper(val node: Node, var count: Int)

    val stack = arrayListOf(Helper(root, 0))
    val result = ArrayList<Int>()
    while (stack.isNotEmpty()) {
        val h = stack.last()
        val node = h.node
        if (h.count == node.children.size) {
            result.add(node.`val`)
            stack.removeAt(stack.lastIndex)
        } else {
            node.children[h.count++]?.let { stack.add(Helper(it, 0)) }
        }
    }
    return result
}