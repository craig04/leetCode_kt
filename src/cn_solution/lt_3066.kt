package cn_solution

import java.util.*

private fun minOperations(nums: IntArray, k: Int): Int {
    val q = nums.mapTo(PriorityQueue()) { it + 0L }
    var ans = 0
    while (true) {
        val a = q.poll()
        if (a >= k)
            return ans
        val b = q.poll()
        q.offer(2 * a + b)
        ans++
    }
}