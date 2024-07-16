package cn_solution

fun numberOfPairs(nums: IntArray): IntArray {
    val map = IntArray(101)
    val cnt = nums.sumOf { ++map[it] and 1 xor 1 }
    return intArrayOf(cnt, nums.size - cnt * 2)
}