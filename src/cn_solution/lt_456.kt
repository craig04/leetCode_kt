package cn_solution

import java.util.*

fun find132pattern(nums: IntArray): Boolean {
    val tail = nums.asSequence().groupingBy { it }.eachCountTo(TreeMap())
    var min = Int.MAX_VALUE
    for (max in nums) {
        tail.merge(max, -1) { a, b ->
            if (a + b == 0) null else a + b
        }
        if (min + 1 < max) {
            val mid = tail.higherKey(min)
            if (mid != null && mid < max)
                return true
        }
        min = minOf(min, max)
    }
    return false
}