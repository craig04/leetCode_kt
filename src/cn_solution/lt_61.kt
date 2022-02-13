package cn_solution

import base.ListNode

fun rotateRight(head: ListNode?, k: Int): ListNode? {
    var temp = head ?: return head
    var size = 1
    while (true) {
        temp = temp.next ?: break
        size++
    }
    temp.next = head
    temp = head
    repeat(size - 1 - (size % k)) {
        temp = temp.next!!
    }
    val result = temp.next
    temp.next = null
    return result
}