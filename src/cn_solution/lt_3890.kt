package cn_solution

import kotlin.math.abs

class Solution_3890 {

    companion object {
        val ans = ArrayList<Int>()

        init {
            val map = HashMap<Int, Int>()
            for (a in 1..1000) {
                val x = a * a * a
                for (b in a..1000) {
                    val y = b * b * b
                    if (x + y > 1000000000)
                        break
                    map.merge(x + y, 1, Int::plus)
                }
            }
            for ((num, cnt) in map)
                if (cnt > 1)
                    ans.add(num)
            ans.sort()
        }
    }

    fun findGoodIntegers(n: Int): List<Int> {
        return ans.take(abs(ans.binarySearch(n) + 1))
    }
}