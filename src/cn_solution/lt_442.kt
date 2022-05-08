package cn_solution

import kotlin.math.abs

fun findDuplicates(nums: IntArray): List<Int> {
    val result = ArrayList<Int>()
    for (n in nums) {
        val x = abs(n)
        if (nums[x - 1] > 0) {
            nums[x - 1] = -nums[x - 1]
        } else {
            result.add(x)
        }
    }
    return result
}