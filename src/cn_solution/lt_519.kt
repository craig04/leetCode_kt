package cn_solution

import kotlin.random.Random

class Solution_519(val m: Int, val n: Int) {

    private val rand = Random.Default
    private var total = m * n
    private val map = HashMap<Int, Int>()

    fun flip(): IntArray {
        val x = rand.nextInt(total--)
        val idx = map[x] ?: x
        map[x] = map[total] ?: total
        return intArrayOf(idx / n, idx % n)
    }

    fun reset() {
        total = m * n
        map.clear()
    }
}