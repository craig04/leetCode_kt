package cn_solution

import base.ListNode

fun numComponents(head: ListNode?, nums: IntArray): Int {
    var result = 0
    val set = nums.toHashSet()
    var node = head
    while (node != null) {
        val temp = node.`val`
        node = node.next
        if (temp !in set)
            continue
        result++
        while (node != null && node.`val` in set)
            node = node.next
    }
    return result
}
