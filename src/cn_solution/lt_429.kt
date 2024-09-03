package cn_solution

import base.Node

fun levelOrder(root: Node?): List<List<Int>> {
    val ans = ArrayList<List<Int>>()
    root ?: return ans
    var curr = ArrayList<Node>()
    var next = ArrayList<Node>()
    curr.add(root)
    while (curr.isNotEmpty()) {
        ans.add(curr.map { node ->
            node.children.asSequence()
                .filterNotNull()
                .forEach { next.add(it) }
            node.`val`
        })
        curr.clear()
        val temp = curr
        curr = next
        next = temp
    }
    return ans
}