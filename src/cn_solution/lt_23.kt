package cn_solution

import base.ListNode
import java.util.*

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val head = ListNode(0)
    var temp = head
    val q = PriorityQueue<ListNode> { lhs, rhs -> lhs.`val` - rhs.`val` }
    lists.filterNotNullTo(q)
    while (q.isNotEmpty()) {
        val node = q.poll()
        temp.next = node
        temp = node
        node.next?.let { q.add(it) }
    }
    return head.next
}