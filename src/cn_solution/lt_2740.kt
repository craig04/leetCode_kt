package cn_solution

fun findValueOfPartition(nums: IntArray): Int {
    nums.sort()
    return (1 until nums.size).minOf { nums[it] - nums[it - 1] }
}