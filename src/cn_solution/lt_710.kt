package cn_solution

import kotlin.random.Random

class Solution_710(val n: Int, blacklist: IntArray) {

    private val map = HashMap<Int, Int>()
    private val m = n - blacklist.size

    init {
        val set = blacklist.filterTo(HashSet()) { it >= m }
        var w = m
        for (b in blacklist) {
            if (b >= m)
                continue
            while (w in set)
                w++
            map[b] = w++
        }
    }

    fun pick(): Int {
        val res = Random.nextInt(m)
        return map[res] ?: res
    }
}