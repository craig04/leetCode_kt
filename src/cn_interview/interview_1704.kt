package cn_interview

fun missingNumber(nums: IntArray): Int {
    val n = nums.size
    return (1 + n) * n / 2 - nums.sum()
}