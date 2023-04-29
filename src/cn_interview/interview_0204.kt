package cn_interview

import base.ListNode

fun partition(head: ListNode?, x: Int): ListNode? {
    val dummy = ListNode(0)
    dummy.next = head
    var front = dummy
    var end: ListNode? = null
    while (true) {
        val next = front.next ?: break
        if (next.`val` < x) {
            front = next
            continue
        }
        front.next = next.next
        next.next = end
        end = next
    }
    front.next = end
    return dummy.next
}