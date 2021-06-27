package solution_cn

import base.ListNode

fun removeElements(head: ListNode?, `val`: Int): ListNode? {
    val dummy = ListNode(0)
    dummy.next = head
    var temp: ListNode? = dummy
    while (temp != null) {
        if (temp.next?.`val` == `val`) {
            temp.next = temp.next?.next
        } else {
            temp = temp.next
        }
    }
    return dummy.next
}