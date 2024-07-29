package cn_solution

fun getConcatenation(nums: IntArray): IntArray {
    val n = nums.size
    return IntArray(n * 2) { nums[it % n] }
}