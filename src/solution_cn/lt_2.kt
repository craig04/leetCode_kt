package solution_cn

import base.ListNode

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val dummy = ListNode(0)
    var tail = dummy
    var c = 0
    var p1 = l1
    var p2 = l2
    while (p1 != null || p2 != null) {
        val sum = (p1?.`val` ?: 0) + (p2?.`val` ?: 0) + c
        val next = ListNode(sum % 10)
        tail.next = next
        tail = next
        c = sum / 10
        p1 = p1?.next
        p2 = p2?.next
    }
    if (c == 1) {
        tail.next = ListNode(1)
    }
    return dummy.next
}