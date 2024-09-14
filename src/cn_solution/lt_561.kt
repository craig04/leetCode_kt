package cn_solution

fun arrayPairSum(nums: IntArray): Int {
    nums.sort()
    return nums.indices.step(2).sumOf { nums[it] }
}