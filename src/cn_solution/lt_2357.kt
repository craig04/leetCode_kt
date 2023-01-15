package cn_solution

fun minimumOperations(nums: IntArray): Int {
    return nums.toHashSet().apply { remove(0) }.size
}