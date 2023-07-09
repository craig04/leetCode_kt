package cn_solution

import base.ListNode

fun pairSum(head: ListNode?): Int {
    var fast = head ?: return 0
    var slow = fast
    while (true) {
        fast = fast.next?.next ?: break
        slow = slow.next ?: break
    }
    fun reverse() {
        var tail: ListNode? = null
        while (true) {
            val temp = slow.next ?: break
            slow.next = temp.next
            temp.next = tail
            tail = temp
        }
        slow.next = tail
    }
    reverse()
    var result = 0
    var a = head
    var b = slow.next
    while (a != null && b != null) {
        result = maxOf(result, a.`val` + b.`val`)
        a = a.next
        b = b.next
    }
    reverse()
    return result
}