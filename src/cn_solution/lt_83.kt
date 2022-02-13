package cn_solution

import base.ListNode

private fun deleteDuplicates(head: ListNode?): ListNode? {
    var temp = head
    while (temp != null) {
        while (temp.next?.`val` == temp.`val`) {
            temp.next = temp.next?.next
        }
        temp = temp.next
    }
    return head
}
