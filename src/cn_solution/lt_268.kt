package cn_solution

fun missingNumber(nums: IntArray): Int {
    return nums.indices.fold(nums.size) { acc, i -> acc xor i xor nums[i] }
}