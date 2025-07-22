package cn_solution

fun maximumMedianSum(nums: IntArray): Long {
    nums.sort()
    val n = nums.size
    return (n / 3 until n step 2).sumOf { nums[it] + 0L }
}