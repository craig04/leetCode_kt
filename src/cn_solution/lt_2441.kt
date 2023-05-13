package cn_solution

import kotlin.math.abs

fun findMaxK(nums: IntArray): Int {
    val set = HashSet<Int>()
    var result = 0
    for (n in nums) {
        if (-n in set)
            result = maxOf(result, abs(n))
        set.add(n)
    }
    return result
}