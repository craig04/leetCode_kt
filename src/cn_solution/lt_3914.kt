package cn_solution

private fun minOperations(nums: IntArray): Long {
    return (1 until nums.size).fold(0L) { ans, i ->
        ans + maxOf(0, nums[i - 1] - nums[i])
    }
}