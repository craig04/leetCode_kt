package cn_solution

import base.ListNode

fun reorderList(head: ListNode?): Unit {
    head ?: return
    var fast: ListNode = head
    var slow: ListNode = head
    while (true) {
        fast = fast.next?.next ?: break
        slow = slow.next ?: break
    }
    var back: ListNode? = null
    while (true) {
        val temp = slow.next ?: break
        slow.next = temp.next
        temp.next = back
        back = temp
    }
    var fake: ListNode = head
    while (back != null) {
        val temp = back.next
        back.next = fake.next
        fake.next = back
        fake = back.next ?: break
        back = temp
    }
}
