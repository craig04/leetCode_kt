package cn_offer

import base.ListNode

private fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    val dummy = ListNode(0)
    var temp = dummy
    var t1 = l1
    var t2 = l2
    while (t1 != null && t2 != null) {
        if (t1.`val` < t2.`val`) {
            temp.next = t1
            t1 = t1.next
        } else {
            temp.next = t2
            t2 = t2.next
        }
        temp = temp.next!!
    }
    temp.next = t1 ?: t2
    return dummy.next
}