package cn_solution

import base.ListNode

fun removeNodes(head: ListNode?): ListNode? {
    fun ListNode?.reverse(): ListNode? {
        var temp: ListNode? = null
        var node = this
        while (node != null) {
            val next = node.next
            node.next = temp
            temp = node
            node = next
        }
        return temp
    }

    val revs = head.reverse()
    var curr = revs
    while (curr != null) {
        val next = curr.next ?: break
        if (curr.`val` > next.`val`)
            curr.next = next.next
        else
            curr = next
    }
    return revs.reverse()
}