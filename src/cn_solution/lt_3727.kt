package cn_solution

private fun maxAlternatingSum(nums: IntArray): Long {
    val s = LongArray(nums.size) { nums[it] * 1L * nums[it] }
    val n = s.size / 2
    s.sort()
    return s.indices.sumOf { if (it < n) -s[it] else s[it] }
}