package cn_solution

import kotlin.math.abs

fun minMoves2(nums: IntArray): Int {
    nums.sort()
    val mid = nums[nums.size / 2]
    return nums.sumOf { abs(it - mid) }
}