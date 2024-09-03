package cn_solution

import base.ListNode

fun mergeNodes(head: ListNode?): ListNode? {
    val dummy = ListNode(0)
    var temp = dummy
    var sum = 0
    var node = head ?: return null
    do {
        node = node.next ?: break
        if (node.`val` == 0) {
            val next = ListNode(sum)
            temp.next = next
            temp = next
            sum = 0
        } else {
            sum += node.`val`
        }
    } while (node.next != null)
    return dummy.next
}