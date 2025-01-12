package cn_solution

import kotlin.math.absoluteValue
import kotlin.math.sign

fun findClosestNumber(nums: IntArray): Int {
    return nums.minBy { it.absoluteValue * 3 - it.sign }
}