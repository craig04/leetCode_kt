package cn_solution

import kotlin.math.abs

fun findDisappearedNumbers(nums: IntArray): List<Int> {
    nums.forEach { nums[abs(it) - 1] = -abs(nums[abs(it) - 1]) }
    return (1..nums.size).filter { nums[it - 1] > 0 }
}