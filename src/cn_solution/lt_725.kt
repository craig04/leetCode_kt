package cn_solution

import base.ListNode

fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
    var len = 0
    var node = head
    while (node != null) {
        len++
        node = node.next
    }
    val x = len / k
    val y = len % k
    node = head
    return Array(k) { i ->
        val pivot = node
        repeat(if (i < y) x else x - 1) {
            node = node?.next
        }
        val next = node?.next
        node?.next = null
        node = next
        pivot
    }
}