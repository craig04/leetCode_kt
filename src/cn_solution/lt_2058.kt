package cn_solution

import base.ListNode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
fun nodesBetweenCriticalPoints(head: ListNode?): IntArray {
    var x = head
    var y = x?.next
    var z = y?.next
    var min = Int.MAX_VALUE
    var first = 0
    var pre = 0
    var pos = 1
    while (x != null && y != null && z != null) {
        if (y.`val` > maxOf(x.`val`, z.`val`) ||
            y.`val` < minOf(x.`val`, z.`val`)
        ) {
            if (pre == 0)
                first = pos
            else
                min = minOf(min, pos - pre)
            pre = pos
        }
        x = y
        y = z
        z = z.next
        pos++
    }
    if (min == Int.MAX_VALUE)
        min = -1
    val max = if (pre == first) -1 else pre - first
    return intArrayOf(min, max)
}