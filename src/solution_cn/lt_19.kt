package solution_cn

import base.ListNode

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    val dummy = ListNode(0)
    dummy.next = head
    var fast = dummy
    var slow = dummy
    repeat(n) {
        fast = fast.next!!
    }
    while (fast.next != null) {
        fast = fast.next!!
        slow = slow.next!!
    }
    slow.next = slow.next?.next
    return dummy.next
}