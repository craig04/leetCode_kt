package cn_lcr

import base.ListNode

fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    var a = headA
    var b = headB
    while (a != b) {
        a = if (a == null) headB else a.next
        b = if (b == null) headA else b.next
    }
    return a
}