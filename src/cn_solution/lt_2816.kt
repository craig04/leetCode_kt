package cn_solution

import base.ListNode
import java.util.*

fun doubleIt(head: ListNode?): ListNode? {
    val s = Stack<Int>()
    var node = head
    while (node != null) {
        s.push(node.`val`)
        node = node.next
    }
    node = null
    var c = 0
    while (s.isNotEmpty()) {
        val n = s.pop() * 2 + c
        c = n / 10
        val temp = ListNode(n % 10)
        temp.next = node
        node = temp
    }
    if (c == 1) {
        node = ListNode(1).apply { next = node }
    }
    return node
}