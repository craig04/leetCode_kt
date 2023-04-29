package cn_interview

import base.ListNode

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val dummy = ListNode(0)
    var head = dummy
    var c = 0
    var n1 = l1
    var n2 = l2
    while (n1 != null || n2 != null) {
        c += (n1?.`val` ?: 0) + (n2?.`val` ?: 0)
        n1 = n1?.next
        n2 = n2?.next
        val next = ListNode(c % 10)
        head.next = next
        head = next
        c /= 10
    }
    if (c != 0) {
        head.next = ListNode(c)
    }
    return dummy.next
}