package cn_lcr

import base.ListNode

fun detectCycle(head: ListNode?): ListNode? {
    var fast = head
    var slow = fast
    do {
        fast = fast?.next?.next ?: return null
        slow = slow?.next ?: return null
    } while (fast != slow)
    slow = head
    while (fast != slow) {
        fast = fast?.next
        slow = slow?.next
    }
    return fast
}