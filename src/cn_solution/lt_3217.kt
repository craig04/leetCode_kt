package cn_solution

import base.ListNode

fun modifiedList(nums: IntArray, head: ListNode?): ListNode? {
    val set = nums.toHashSet()
    val fake = ListNode(0, head)
    var node = fake
    while (true) {
        val next = node.next
        when {
            next == null -> break
            next.`val` !in set -> node = next
            else -> node.next = next.next
        }
    }
    return fake.next
}