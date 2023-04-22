package cn_solution

import base.ListNode
import java.util.*
import kotlin.collections.ArrayList

fun nextLargerNodes(head: ListNode?): IntArray {
    val result = ArrayList<Int>()
    val list = ArrayList<Int>()
    val stack = Stack<Int>()
    var node = head
    var count = 0
    while (node != null) {
        val num = node.`val`
        list.add(num)
        result.add(0)
        while (stack.isNotEmpty() && list[stack.peek()] < num) {
            result[stack.peek()] = num
            stack.pop()
        }
        stack.add(count++)
        node = node.next
    }
    return result.toIntArray()
}