package cn_solution

import java.util.*

class StockPrice() {

    private var cur = 0
    private val map = HashMap<Int, Int>()
    private val max = PriorityQueue<IntArray> { a, b -> b[1] - a[1] }
    private val min = PriorityQueue<IntArray> { a, b -> a[1] - b[1] }

    fun update(timestamp: Int, price: Int) {
        val e = intArrayOf(timestamp, price)
        cur = maxOf(cur, timestamp)
        map[timestamp] = price
        max += e
        min += e
    }

    fun current(): Int {
        return map[cur] ?: 0
    }

    fun maximum(): Int {
        return max.doPeek()
    }

    fun minimum(): Int {
        return min.doPeek()
    }

    fun PriorityQueue<IntArray>.doPeek(): Int {
        while (isNotEmpty()) {
            val (time, price) = peek()
            if (map[time] == price)
                return price
            poll()
        }
        return 0
    }
}