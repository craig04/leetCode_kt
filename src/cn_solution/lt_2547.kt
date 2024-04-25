package cn_solution

private fun minCost(nums: IntArray, k: Int): Int {
    val n = nums.size
    val dp = LongArray(n + 1)
    for (i in nums.indices.reversed()) {
        val map = HashMap<Int, Int>()
        var cost = 0
        dp[i] = (i until n).minOf { j ->
            val cnt = map[nums[j]] ?: 0
            map[nums[j]] = cnt + 1
            if (cnt == 1)
                cost += 2
            else if (cnt > 0)
                cost += 1
            cost + k + dp[j + 1]
        }
    }
    return dp[0].toInt()
}