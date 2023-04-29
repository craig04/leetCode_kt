package cn_solution

import kotlin.math.abs

fun findDisappearedNumbers(nums: IntArray): List<Int> {
    nums.forEach { nums[abs(it) - 1] = -abs(nums[abs(it) - 1]) }
    return nums.indices.asSequence().filter { nums[it] > 0 }.map { it + 1 }.toList()
}