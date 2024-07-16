package cn_solution

import kotlin.math.abs

private fun minCost(basket1: IntArray, basket2: IntArray): Long {
    val map = HashMap<Int, Int>()
    for (i in basket1.indices) {
        map.merge(basket1[i], 1, Int::plus)
        map.merge(basket2[i], -1, Int::plus)
    }
    var min = Int.MAX_VALUE
    var step = 0
    val swap = ArrayList<IntArray>()
    for ((num, cnt) in map) {
        min = minOf(min, num)
        val c = abs(cnt)
        if (c == 0)
            continue
        if (c and 1 == 1)
            return -1
        step += c / 2
        swap.add(intArrayOf(num, c / 2))
    }
    min *= 2
    step /= 2
    swap.sortBy { it[0] }
    var cost = 0L
    var i = 0
    while (step > 0) {
        val used = minOf(step, swap[i][1])
        step -= used
        cost += used * minOf(min, swap[i++][0]).toLong()
    }
    return cost
}