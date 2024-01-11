package cn_solution

import base.TreeNode

fun recoverFromPreorder(traversal: String): TreeNode? {
    val stack = ArrayList<TreeNode>()
    var i = 0
    while (i != traversal.length) {
        var j = (i until traversal.length).first { traversal[it] != '-' }
        val layer = j - i
        var value = 0
        while (j != traversal.length && traversal[j] != '-')
            value = value * 10 + (traversal[j++] - '0')
        while (stack.size > layer)
            stack.removeLast()
        val node = TreeNode(value)
        stack.lastOrNull()?.run {
            if (left == null)
                left = node
            else
                right = node
        }
        stack.add(node)
        i = j
    }
    return stack.first()
}