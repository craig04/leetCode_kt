package cn_solution

import base.TreeNode

fun maxLevelSum(root: TreeNode?): Int {
    root ?: return 0
    val q = ArrayDeque<TreeNode>()
    var result = 0
    var level = 0
    var sum = Int.MIN_VALUE
    q.addFirst(root)
    while (q.isNotEmpty()) {
        var temp = 0
        repeat(q.size) {
            val node = q.removeFirst()
            temp += node.`val`
            node.left?.also { q.addLast(it) }
            node.right?.also { q.addLast(it) }
        }
        level++
        if (temp > sum) {
            sum = temp
            result = level
        }
    }
    return result
}