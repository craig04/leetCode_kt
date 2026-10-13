package cn_solution

fun minDeletions(nums: IntArray): Int {
    return (1 until nums.size).count { nums[it - 1] == nums[it] }
}