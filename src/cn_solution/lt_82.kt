package cn_solution

import base.ListNode

private fun deleteDuplicates(head: ListNode?): ListNode? {
    val dummy = ListNode(0)
    dummy.next = head
    var slow = dummy
    while (true) {
        var fast = slow.next ?: break
        val num = fast.`val`
        while (fast.next?.`val` == num) {
            fast = fast.next!!
        }
        if (fast != slow.next) {
            slow.next = fast.next
        } else {
            slow = fast
        }
    }
    return dummy.next
}