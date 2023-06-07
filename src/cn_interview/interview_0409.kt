package cn_interview

import base.TreeNode

fun BSTSequences(root: TreeNode?): List<List<Int>> {
    val result = ArrayList<List<Int>>()
    val list = ArrayList<Int>()
    val nodes = ArrayDeque<TreeNode>()
    root?.let { nodes.add(it) }
    fun generate() {
        if (nodes.isEmpty()) {
            result.add(ArrayList(list))
            return
        }
        repeat(nodes.size) {
            val node = nodes.removeFirst()
            list.add(node.`val`)
            node.left?.let { nodes.addLast(it) }
            node.right?.let { nodes.addLast(it) }
            generate()
            node.right?.let { nodes.removeLast() }
            node.left?.let { nodes.removeLast() }
            list.removeAt(list.lastIndex)
            nodes.addLast(node)
        }
    }
    generate()
    return result
}