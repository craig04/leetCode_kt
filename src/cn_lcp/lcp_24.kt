package cn_lcp

import java.util.*

fun numsGame(nums: IntArray): IntArray {
    val modulo = 1000000007
    val q1 = PriorityQueue<Int> { a, b -> b - a }
    val q2 = PriorityQueue<Int> { a, b -> a - b }
    var s1 = 0L
    var s2 = 0L
    return IntArray(nums.size) {
        val num = nums[it] - it
        if (q1.size == q2.size) {
            q2.offer(num)
            val t = q2.poll()
            q1.offer(t)
            s1 += t
            s2 += num - t
        } else {
            q1.offer(num)
            val t = q1.poll()
            q2.offer(t)
            s1 += num - t
            s2 += t
        }
        val mid = q1.peek().toLong()
        ((mid * q1.size - s1 + s2 - mid * q2.size) % modulo).toInt()
    }
}