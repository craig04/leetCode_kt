package cn_solution

import kotlin.math.floor

fun smallestAbsent(nums: IntArray): Int {
    val set = nums.toHashSet()
    val sum = nums.sum()
    var ans = maxOf(floor(sum * 1.0 / nums.size).toInt() + 1, 1)
    while (ans in set)
        ans++
    return ans
}