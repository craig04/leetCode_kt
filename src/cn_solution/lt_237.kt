package cn_solution

import base.ListNode

fun deleteNode(node: ListNode?) {
    node?.next?.let {
        node.`val` = it.`val`
        node.next = it.next
    }
}