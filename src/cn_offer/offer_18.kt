package cn_offer

import base.ListNode

fun deleteNode(head: ListNode?, `val`: Int): ListNode? {
    if (head == null || head.`val` == `val`) {
        return head?.next
    }
    var node = head
    while (true) {
        val next = node?.next ?: break
        if (next.`val` == `val`) {
            node.next = next.next
            break
        }
        node = next
    }
    return head
}