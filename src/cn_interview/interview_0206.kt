package cn_interview

import base.ListNode

fun isPalindrome(head: ListNode?): Boolean {
    var slow = head
    var fast = head
    while (true) {
        fast = fast?.next?.next ?: break
        slow = slow?.next
    }
    var tail: ListNode? = null
    while (true) {
        val next = slow?.next ?: break
        slow.next = next.next
        next.next = tail
        tail = next
    }
    var result = true
    var first = head
    var second = tail
    while (first != null && second != null) {
        if (first.`val` != second.`val`) {
            result = false
            break
        }
        first = first.next
        second = second.next
    }

    while (tail != null) {
        val next = tail.next
        tail.next = slow?.next
        slow?.next = tail
        tail = next
    }
    return result
}