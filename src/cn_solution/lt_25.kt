package cn_solution

import base.ListNode

fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    if (k == 1)
        return head
    val dummy = ListNode(0)
    dummy.next = head
    var h = dummy
    loop@ while (true) {
        var t = h
        for (i in 0 until k) t = t.next ?: break@loop
        var temp = h.next
        val pivot = temp ?: break
        h.next = t.next
        t.next = null
        while (temp != null) {
            val next = temp.next
            temp.next = h.next
            h.next = temp
            temp = next
        }
        h = pivot
    }
    return dummy.next
}
