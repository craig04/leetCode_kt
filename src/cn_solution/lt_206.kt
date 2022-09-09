package cn_solution

import base.ListNode

fun reverseList(head: ListNode?): ListNode? {
    var tail: ListNode? = null
    var node = head
    while (node != null) {
        val temp = node.next
        node.next = tail
        tail = node
        node = temp
    }
    return tail
}