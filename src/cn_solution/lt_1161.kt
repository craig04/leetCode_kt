package cn_solution

import base.TreeNode

fun maxLevelSum(root: TreeNode?): Int {
    root ?: return 0
    val q = ArrayDeque<TreeNode>()
    var layer = 0
    var max = Int.MIN_VALUE
    var ans = 0
    q.addFirst(root)
    while (q.isNotEmpty()) {
        var sum = 0
        repeat(q.size) {
            val node = q.removeFirst()
            sum += node.`val`
            node.left?.apply(q::addLast)
            node.right?.apply(q::addLast)
        }
        layer++
        if (max < sum) {
            max = sum
            ans = layer
        }
    }
    return ans
}