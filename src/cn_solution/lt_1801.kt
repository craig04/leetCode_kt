package cn_solution

import java.util.*

fun getNumberOfBacklogOrders(orders: Array<IntArray>): Int {
    val sell = PriorityQueue(Comparator<IntArray> { l, r -> l[0] - r[0] })
    val buy = PriorityQueue(Comparator<IntArray> { l, r -> r[0] - l[0] })
    var result = 0L
    for (order in orders) {
        result += order[1]
        if (order[2] == 0) {
            var count = order[1]
            while (count > 0) {
                val cheap = sell.peek() ?: break
                if (cheap[0] > order[0]) break
                val deal = minOf(count, cheap[1])
                count -= deal
                cheap[1] -= deal
                result -= deal shl 1
                if (cheap[1] == 0)
                    sell.poll()
            }
            if (count != 0)
                buy.offer(intArrayOf(order[0], count))
        } else {
            var count = order[1]
            while (count > 0) {
                val expensive = buy.peek() ?: break
                if (expensive[0] < order[0]) break
                val deal = minOf(count, expensive[1])
                count -= deal
                expensive[1] -= deal
                result -= deal shl 1
                if (expensive[1] == 0)
                    buy.poll()
            }
            if (count != 0)
                sell.offer(intArrayOf(order[0], count))
        }
    }
    return (result % 1000000007).toInt()
}
