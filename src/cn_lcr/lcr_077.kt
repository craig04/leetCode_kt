package cn_lcr

import base.ListNode

fun sortList(head: ListNode?): ListNode? {
    var length = 0
    var temp = head
    while (temp != null) {
        temp = temp.next
        length++
    }
    fun sort(head: ListNode?, len: Int): ListNode? {
        if (len <= 1)
            return head
        val half = len / 2
        var pivot = head
        repeat(half - 1) { pivot = pivot?.next }
        val next = pivot?.next
        pivot?.next = null
        pivot = next
        var first = sort(head, half)
        var second = sort(pivot, len - half)
        val dummy = ListNode(0)
        var tail = dummy
        while (first != null && second != null) {
            if (first.`val` < second.`val`) {
                tail.next = first
                tail = first
                first = first.next
            } else {
                tail.next = second
                tail = second
                second = second.next
            }
        }
        tail.next = first ?: second
        return dummy.next
    }
    return sort(head, length)
}