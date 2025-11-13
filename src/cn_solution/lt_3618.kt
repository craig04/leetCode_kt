package cn_solution

import kotlin.math.abs

private fun splitArray(nums: IntArray): Long {
    var diff = 0L - nums[0]
    if (nums.size >= 2)
        diff -= nums[1]
    val p = BooleanArray(nums.size) { true }
    for (i in 2 until nums.size) {
        if (p[i]) {
            diff += nums[i]
            for (j in i + i until nums.size step i)
                p[j] = false
        } else {
            diff -= nums[i]
        }
    }
    return abs(diff)
}