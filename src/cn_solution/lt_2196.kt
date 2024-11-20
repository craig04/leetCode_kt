package cn_solution

import base.TreeNode

fun createBinaryTree(descriptions: Array<IntArray>): TreeNode? {
    val nodes = HashMap<Int, TreeNode>()
    val children = HashSet<Int>()
    for ((p, c, l) in descriptions) {
        val parent = nodes.getOrPut(p) { TreeNode(p) }
        val child = nodes.getOrPut(c) { TreeNode(c) }
        if (l == 1)
            parent.left = child
        else
            parent.right = child
        children.add(c)
    }
    children.forEach(nodes::remove)
    return nodes.values.first()
}