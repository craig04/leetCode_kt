package cn_solution

fun minimumDifference(nums: IntArray, k: Int): Int {
    nums.sort()
    return (0..nums.size - k).minOf { nums[it + k - 1] - nums[it] }
}