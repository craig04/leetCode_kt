package cn_solution

import base.ListNode

fun insertionSortList(head: ListNode?): ListNode? {
    val dummy = ListNode(Int.MIN_VALUE)
    dummy.next = head
    var node = dummy
    while (true) {
        val next = node.next ?: break
        if (node.`val` <= next.`val`) {
            node = next
            continue
        }
        var prev = dummy
        while (prev != node) {
            val temp = prev.next ?: break
            if (temp.`val` >= next.`val`)
                break
            prev = temp
        }
        node.next = next.next
        next.next = prev.next
        prev.next = next
    }
    return dummy.next
}