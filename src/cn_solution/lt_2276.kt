package cn_solution

import java.util.TreeMap

class CountIntervals() {

    private val itv = TreeMap<Int, Int>()
    private var cnt = 0

    fun add(left: Int, right: Int) {
        var low = left
        var high = right
        val higherKey = itv.higherKey(right) ?: Int.MAX_VALUE
        while (true) {
            val e = itv.lowerEntry(higherKey)
            if (e == null || e.value < low)
                break
            low = minOf(low, e.key)
            high = maxOf(high, e.value)
            itv.remove(e.key)
            cnt -= (e.value - e.key + 1)
        }
        itv[low] = high
        cnt += high - low + 1
    }

    fun count(): Int {
        return cnt
    }
}