package cn_solution

import base.ListNode

fun getDecimalValue(head: ListNode?): Int {
    var ans = 0
    var node = head
    while (node != null) {
        ans = ans.shl(1) + node.`val`
        node = node.next
    }
    return ans
}