package cn_solution

import java.util.*

fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    val len = nums.size
    val q = PriorityQueue<Int> { lhs, rhs -> rhs - lhs }
    (0 until k - 1).forEach { q.add(nums[it] * len + it) }
    return IntArray(len - k + 1) {
        val t = it + k - 1
        q.add(nums[t] * len + t)
        while (q.peek() % len < it)
            q.poll()
        q.peek() / len
    }
}