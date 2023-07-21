package cn_offer

import base.ListNode

fun getKthFromEnd(head: ListNode?, k: Int): ListNode? {
    var slow = head
    var fast = head
    repeat(k - 1) { fast = fast?.next }
    while (true) {
        fast = fast?.next ?: break
        slow = slow?.next
    }
    return slow
}