package cn_lcr

import kotlin.math.sign

fun findMaximumXOR(nums: IntArray): Int {
    class Node {
        val next = Array<Node?>(2) { null }
    }

    val root = Node()
    val high = nums.reduce { a, b -> a or b }.takeHighestOneBit()
    fun handle(n: Int): Int {
        var node = root
        var temp = high
        do {
            val idx = n.and(temp).sign
            val next = node.next[idx] ?: Node()
            node.next[idx] = next
            node = next
            temp = temp.shr(1)
        } while (temp != 0)
        node = root
        temp = high
        var result = 0
        do {
            var idx = 1 - n.and(temp).sign
            if (node.next[idx] == null) {
                idx = idx xor 1
            } else {
                result = result xor temp
            }
            node = node.next[idx]!!
            temp = temp.shr(1)
        } while (temp != 0)
        return result
    }
    return nums.maxOf { handle(it) }
}