package cn_solution

import kotlin.math.abs

fun findIndices(nums: IntArray, indexDifference: Int, valueDifference: Int): IntArray {
    var min = 0
    var max = 0
    for (i in 0 until nums.size - indexDifference) {
        if (nums[i] < nums[min])
            min = i
        if (nums[i] > nums[max])
            max = i
        val j = i + indexDifference
        if (abs(nums[j] - nums[min]) >= valueDifference)
            return intArrayOf(min, j)
        if (abs(nums[j] - nums[max]) >= valueDifference)
            return intArrayOf(max, j)
    }
    return intArrayOf(-1, -1)
}