package cn_solution

import kotlin.math.abs

fun countValidSelections(nums: IntArray): Int {
    val sum = nums.sum()
    var gap = sum
    var ans = 0
    for (num in nums) {
        when {
            num != 0 -> gap -= num * 2
            gap < -1 -> break
            gap <= 1 -> ans += 2 - abs(gap)
        }
    }
    return ans
}