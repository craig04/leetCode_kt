package cn_solution

import java.util.*

fun getNumberOfBacklogOrders(orders: Array<IntArray>): Int {
    var ans = 0L
    val candidates = arrayOf(
        PriorityQueue<IntArray> { (a), (b) -> b.compareTo(a) },
        PriorityQueue<IntArray> { (a), (b) -> a.compareTo(b) }
    )
    for (order in orders) {
        ans += order[1]
        val q = candidates[order[2] xor 1]
        while (order[1] > 0 && q.isNotEmpty()) {
            val other = q.peek()
            if (order[0].compareTo(other[0]) == order[2].compareTo(other[2]))
                break
            val count = minOf(order[1], other[1])
            order[1] -= count
            other[1] -= count
            ans -= count * 2
            if (other[1] == 0)
                q.poll()
        }
        if (order[1] > 0)
            candidates[order[2]] += order
    }
    return ans.mod(1000000007)
}