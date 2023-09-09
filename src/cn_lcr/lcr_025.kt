package cn_lcr

import base.ListNode

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    fun ListNode?.toArrayList(): ArrayList<Int> {
        val result = ArrayList<Int>()
        var node = this
        while (node != null) {
            result.add(node.`val`)
            node = node.next
        }
        return result
    }

    val a1 = l1.toArrayList()
    val a2 = l2.toArrayList()
    var c = 0
    val sum = ArrayList<Int>()
    while (a1.isNotEmpty() || a2.isNotEmpty()) {
        val s = (a1.removeLastOrNull() ?: 0) + (a2.removeLastOrNull() ?: 0) + c
        sum.add(s % 10)
        c = s / 10
    }
    if (c != 0)
        sum.add(c)
    return sum.fold(null as ListNode?) { head, s ->
        ListNode(s).apply { next = head }
    }
}