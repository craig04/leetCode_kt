package cn_solution

fun canSplitArray(nums: List<Int>, m: Int): Boolean {
    return nums.size <= 2 || (1 until nums.size).any { nums[it - 1] + nums[it] >= m }
}