package cn_solution

import java.util.*

fun maxRemoval(nums: IntArray, queries: Array<IntArray>): Int {
    queries.sortBy { it[0] }
    val q = PriorityQueue<Int> { a, b -> b - a }
    val n = nums.size
    val m = queries.size
    val dec = IntArray(n + 1)
    var acc = 0
    var j = 0
    for (i in nums.indices) {
        while (j != m && queries[j][0] <= i)
            q.offer(queries[j++][1])
        acc -= dec[i]
        while (acc < nums[i]) {
            if (q.isEmpty() || q.peek() < i)
                return -1
            acc++
            dec[q.poll() + 1]++
        }
    }
    return q.size
}