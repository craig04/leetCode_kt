package cn_solution

private fun maxSum(nums: IntArray, k: Int, mul: Int): Long {
    nums.sortDescending()
    return (0 until k).sumOf { nums[it] * maxOf(mul - it + 0L, 1L) }
}