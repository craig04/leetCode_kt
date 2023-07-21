package cn_solution

import base.ListNode

fun partition(head: ListNode?, x: Int): ListNode? {
    val first = ListNode(0)
    val second = ListNode(0)
    var a = first
    var b = second
    var node = head
    while (node != null) {
        if (node.`val` < x) {
            a.next = node
            a = node
        } else {
            b.next = node
            b = node
        }
        node = node.next
    }
    a.next = second.next
    b.next = null
    return first.next
}