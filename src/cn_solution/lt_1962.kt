package cn_solution

import java.util.*

fun minStoneSum(piles: IntArray, k: Int): Int {
    val q = PriorityQueue<Int> { l, r -> r - l }
    var sum = 0
    for (p in piles) {
        q.offer(p)
        sum += p
    }
    repeat(k) {
        val p = q.poll()
        sum -= p / 2
        q.offer((p + 1) / 2)
    }
    return sum
}