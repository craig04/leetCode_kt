package cn_solution

import kotlin.math.abs

fun maxAdjacentDistance(nums: IntArray): Int {
    return (1 until nums.size).maxOf { abs(nums[it] - nums[it - 1]) }
        .coerceAtLeast(abs(nums.first() - nums.last()))
}