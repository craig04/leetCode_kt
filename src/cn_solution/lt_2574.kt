package cn_solution

import kotlin.math.abs

fun leftRightDifference(nums: IntArray): IntArray {
    var left = 0
    var right = nums.sum()
    val ans = IntArray(nums.size)
    for (i in nums.indices) {
        right -= nums[i]
        ans[i] = abs(left - right)
        left += nums[i]
    }
    return ans
}