package cn_solution

import base.ListNode

fun isPalindrome(head: ListNode?): Boolean {
    var fast = head ?: return true
    var slow = fast
    while (true) {
        fast = fast.next?.next ?: break
        slow = slow.next ?: break
    }
    var tail: ListNode? = null
    while (true) {
        val next = slow.next ?: break
        val temp = next.next
        next.next = tail
        tail = next
        slow.next = temp
    }
    var front = head
    while (front != null && tail != null) {
        if (front.`val` != tail.`val`)
            return false
        front = front.next
        tail = tail.next
    }
    return true
}