package solution

import base.ListNode

fun getDecimalValue(head: ListNode?): Int {

    var result = 0
    var node = head
    while (node != null) {
        result = result.shl(1) + node.`val`
        node = node.next
    }
    return result
}