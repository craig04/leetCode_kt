package cn_interview

import base.ListNode

fun kthToLast(head: ListNode?, k: Int): Int {
    var slow = head
    var fast = head
    repeat(k) {
        fast = fast?.next
    }
    while (fast != null) {
        fast = fast?.next
        slow = slow?.next
    }
    return slow?.`val` ?: 0
}
