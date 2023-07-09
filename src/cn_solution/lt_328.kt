package cn_solution

import base.ListNode

fun oddEvenList(head: ListNode?): ListNode? {
    var node = head ?: return null
    val dummy = ListNode(0)
    var tail = dummy
    while (true) {
        val next = node.next
        node.next = next?.next
        tail.next = next
        node = node.next ?: break
        tail = next ?: break
    }
    node.next = dummy.next
    return head
}