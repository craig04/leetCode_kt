package cn_solution

fun numberGame(nums: IntArray): IntArray {
    nums.sort()
    return IntArray(nums.size) { nums[it xor 1] }
}