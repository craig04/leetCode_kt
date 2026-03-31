package cn_solution

import kotlin.math.abs

fun getMinDistance(nums: IntArray, target: Int, start: Int): Int {
    return nums.indices.asSequence()
        .filter { nums[it] == target }
        .minOf { abs(it - start) }
}