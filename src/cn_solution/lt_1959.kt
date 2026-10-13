package cn_solution

fun minSpaceWastedKResizing(nums: IntArray, k: Int): Int {
    val n = nums.size
    val dp = Array(n + 1) { IntArray(k + 2) { Int.MAX_VALUE / 2 } }
    dp[0][0] = 0
    for (r in nums.indices) {
        var max = 0
        var sum = 0
        for (l in r downTo 0) {
            max = maxOf(max, nums[l])
            sum += nums[l]
            val waste = max * (r - l + 1) - sum
            for (i in 1..k + 1)
                dp[r + 1][i] = minOf(dp[r + 1][i], dp[l][i - 1] + waste)
        }
    }
    return dp[n][k + 1]
}