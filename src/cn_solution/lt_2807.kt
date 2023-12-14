package cn_solution

import base.ListNode

fun insertGreatestCommonDivisors(head: ListNode?): ListNode? {
    fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    var node = head ?: return null
    do {
        val next = node.next ?: break
        val gcd = gcd(node.`val`, next.`val`)
        val temp = ListNode(gcd)
        temp.next = next
        node.next = temp
        node = next
    } while (true)
    return head
}