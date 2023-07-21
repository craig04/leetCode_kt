package cn_offer

import base.ListNode

fun reversePrint(head: ListNode?): IntArray {
    val list = ArrayList<Int>()
    var node = head
    while (node != null) {
        list.add(node.`val`)
        node = node.next
    }
    return IntArray(list.size) { list[list.lastIndex - it] }
}