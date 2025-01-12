package cn_solution

fun countPartitions(nums: IntArray): Int {
    return if (nums.sum() % 2 == 0) nums.lastIndex else 0
}