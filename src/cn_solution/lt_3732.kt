package cn_solution

import kotlin.math.abs

private fun maxProduct(nums: IntArray): Long {
    var max1 = 0
    var max2 = 0
    for (i in nums.indices) {
        val num = abs(nums[i])
        if (num > max1) {
            max2 = max1
            max1 = num
        } else if (num > max2) {
            max2 = num
        }
    }
    return 100000L * max1 * max2
}