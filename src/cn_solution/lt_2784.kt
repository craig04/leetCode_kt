package cn_solution

import kotlin.math.abs

fun isGood(nums: IntArray): Boolean {
    val n = nums.lastIndex
    var cnt = 0
    for (num in nums) {
        val x = abs(num)
        if (x > n || x == n && ++cnt == 3 || x < n && nums[x] < 0)
            return false
        if (x < n)
            nums[x] = -nums[x]
    }
    return cnt == 2
}