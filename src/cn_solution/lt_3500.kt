package cn_solution

fun minimumCost(nums: IntArray, cost: IntArray, k: Int): Long {
    val n = nums.size
    val pre = LongArray(n + 1)
    cost.forEachIndexed { i, c -> pre[i + 1] = pre[i] + c }
    val dp = LongArray(n + 1)
    var sum = 0L
    for (i in 1..n) {
        sum += nums[i - 1]
        dp[i] = (0 until i).minOf { j ->
            dp[j] + sum * (pre[i] - pre[j]) + k * (pre[n] - pre[j])
        }
    }
    return dp[n]
}