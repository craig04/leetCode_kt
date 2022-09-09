package cn_solution

import base.ListNode

fun hasCycle(head: ListNode?): Boolean {
    var fast = head
    var slow = head
    while (fast != null) {
        fast = fast.next?.next ?: break
        slow = slow?.next
        if (fast == slow) return true
    }
    return false
}