package cn_solution

import base.ListNode

fun deleteMiddle(head: ListNode?): ListNode? {
    val dummy = ListNode(0)
    dummy.next = head
    var fast = dummy
    var slow = dummy
    while (true) {
        fast = fast.next?.next ?: break
        slow = slow.next ?: break
    }
    slow.next = slow.next?.next
    return dummy.next
}