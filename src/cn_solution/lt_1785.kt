package cn_solution

import kotlin.math.abs

fun minElements(nums: IntArray, limit: Int, goal: Int): Int {
    val sum = nums.sumOf(Int::toLong)
    return ((abs(sum - goal) + limit - 1) / limit).toInt()
}