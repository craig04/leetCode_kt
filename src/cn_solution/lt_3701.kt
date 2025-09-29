package cn_solution

fun alternatingSum(nums: IntArray): Int {
    return nums.indices.sumOf { if (it % 2 == 0) nums[it] else -nums[it] }
}