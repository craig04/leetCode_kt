package cn_solution

import java.util.*

fun isPossibleDivide(nums: IntArray, k: Int): Boolean {
    val map = TreeMap<Int, Int>()
    for (num in nums)
        map.merge(num, 1, Int::plus)
    while (map.isNotEmpty()) {
        val s = map.firstKey()
        for (i in s until s + k) {
            val cnt = map.merge(i, -1) { a, b ->
                if (a + b == 0) null else a + b
            }
            if (cnt == -1)
                return false
        }
    }
    return true
}