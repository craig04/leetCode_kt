package cn_solution

import base.TreeNode

fun averageOfLevels(root: TreeNode?): DoubleArray {
    val result = ArrayList<Double>()
    val q = ArrayDeque<TreeNode>()
    fun TreeNode?.enqueue() = this?.let { q.add(it) }
    root.enqueue()
    while (q.isNotEmpty()) {
        var cnt = 0
        var sum = 0.0
        repeat(q.size) {
            val node = q.removeFirst()
            cnt++
            sum += node.`val`
            node.left.enqueue()
            node.right.enqueue()
        }
        result.add(sum / cnt)
    }
    return result.toDoubleArray()
}