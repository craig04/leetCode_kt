package cn_solution

import base.ListNode

fun swapNodes(head: ListNode?, k: Int): ListNode? {
    var node = head
    repeat(k - 1) { node = node?.next }
    var slow = head
    var fast = node
    while (true) {
        fast = fast?.next ?: break
        slow = slow?.next
    }
    val temp = node?.`val` ?: 0
    node?.`val` = slow?.`val` ?: 0
    slow?.`val` = temp
    return head
}