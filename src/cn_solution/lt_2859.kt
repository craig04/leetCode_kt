package cn_solution

fun sumIndicesWithKSetBits(nums: List<Int>, k: Int): Int {
    return nums.indices.asSequence()
        .filter { it.countOneBits() == k }
        .sumOf { nums[it] }
}