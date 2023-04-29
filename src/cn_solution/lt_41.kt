package cn_solution

import kotlin.math.abs

/**
 * Swap method
 */
fun firstMissingPositive(nums: IntArray): Int {
    val n = nums.size
    val range = 1..n
    for (i in nums.indices) {
        while (nums[i] in range && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
            val tmp = nums[nums[i] - 1]
            nums[nums[i] - 1] = nums[i]
            nums[i] = tmp
        }
    }
    return (1..n).firstOrNull { nums[it - 1] != it } ?: (n + 1)
}

/**
 * Hash method
 */
fun firstMissingPositive_hash(nums: IntArray): Int {
    val n = nums.size
    val range = 1..n
    for (i in nums.indices) {
        if (nums[i] !in range)
            nums[i] = n + 1
    }
    nums.forEach {
        val m = abs(it)
        if (m in range)
            nums[m - 1] = -abs(nums[m - 1])
    }
    return (1..n).firstOrNull { nums[it - 1] > 0 } ?: (n + 1)
}