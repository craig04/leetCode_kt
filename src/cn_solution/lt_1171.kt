package cn_solution

import base.ListNode

fun removeZeroSumSublists(head: ListNode?): ListNode? {
    val dummy = ListNode(0)
    dummy.next = head
    var sum = 0
    var node: ListNode? = dummy
    val pre = HashMap<Int, ListNode>()
    while (node != null) {
        sum += node.`val`
        pre[sum] = node
        node = node.next
    }
    sum = 0
    node = dummy
    while (node != null) {
        sum += node.`val`
        val next = pre[sum]
        if (next != null)
            node.next = next.next
        node = node.next
    }
    return dummy.next
}