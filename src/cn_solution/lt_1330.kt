package cn_solution

import kotlin.math.abs

fun maxValueAfterReverse(nums: IntArray): Int {
    val n = nums.size
    var base = 0
    var diff = 0
    var max = Int.MIN_VALUE
    var min = Int.MAX_VALUE
    for (i in 0 until nums.lastIndex) {
        base += abs(nums[i + 1] - nums[i])
        diff = maxOf(diff, abs(nums[i + 1] - nums[0]) - abs(nums[i + 1] - nums[i]))
        diff = maxOf(diff, abs(nums[n - 1] - nums[i]) - abs(nums[i + 1] - nums[i]))
        max = maxOf(max, minOf(nums[i + 1], nums[i]))
        min = minOf(min, maxOf(nums[i + 1], nums[i]))
    }
    return base + maxOf(0, diff, 2 * (max - min))
}