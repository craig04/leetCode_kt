package cn_solution

import java.util.*
import kotlin.collections.HashMap

fun avoidFlood(rains: IntArray): IntArray {
    val n = rains.size
    val candidates = TreeSet<Int>()
    val days = HashMap<Int, Int>()
    val result = IntArray(n)
    rains.forEachIndexed { day, r ->
        if (r == 0) {
            candidates.add(day)
            return@forEachIndexed
        }
        result[day] = -1
        val last = days.put(r, day)
        if (last != null) {
            val temp = candidates.higher(last) ?: return intArrayOf()
            candidates.remove(temp)
            result[temp] = r
        }
    }
    result.forEachIndexed { day, r -> if (r == 0) result[day] = 1 }
    return result
}