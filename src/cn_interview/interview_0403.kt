package cn_interview

import base.ListNode
import base.TreeNode


fun listOfDepth(tree: TreeNode?): Array<ListNode?> {
    val result = ArrayList<ListNode?>()
    val q = ArrayDeque<TreeNode>()
    val dummy = ListNode(0)
    tree?.also { q.add(it) }
    while (q.isNotEmpty()) {
        var node = dummy
        repeat(q.size) {
            val front = q.removeFirst()
            front.left?.also { q.add(it) }
            front.right?.also { q.add(it) }
            val next = ListNode(front.`val`)
            node.next = next
            node = next
        }
        result.add(dummy.next)
    }
    return Array(result.size) { result[it] }
}