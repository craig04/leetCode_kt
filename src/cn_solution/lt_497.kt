package cn_solution

import java.util.*

class Solution_497(private val rects: Array<IntArray>) {

    private val points = IntArray(rects.size)
    private val random = Random()

    init {
        var total = 0
        for (i in rects.indices) {
            val r = rects[i]
            val p = (r[2] - r[0] + 1) * (r[3] - r[1] + 1)
            total += p
            points[i] = total
        }
    }

    fun pick(): IntArray {
        var rand = random.nextInt(points.last())
        val index = points.binarySearch(rand)
        val r = rects[index]
        val width = r[2] - r[0] + 1
        if (index != 0)
            rand -= points[index - 1]
        return intArrayOf(r[0] + rand % width, r[1] + rand / width)
    }

    private fun IntArray.binarySearch(target: Int): Int {
        var l = 0
        var r = lastIndex
        while (l != r) {
            val m = (l + r) / 2
            when {
                this[m] > target -> r = m
                this[m] < target -> l = m + 1
                else -> return m + 1
            }
        }
        return r
    }
}