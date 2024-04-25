package cn_solution

private fun minCost(nums: IntArray, x: Int): Long {
    val n = nums.size
    val dp = nums.copyOf()
    return nums.indices.minOf { k ->
        nums.indices.sumOf { i ->
            dp[i] = minOf(dp[i], nums[(i + k) % n])
            dp[i].toLong()
        } + x.toLong() * k
    }
}