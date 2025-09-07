package cn_solution

fun countStableSubsequences(nums: IntArray): Int {
    val modulo = 1000000007
    val dp = Array(2) { LongArray(3) }
    for (num in nums) {
        val x = num % 2
        val y = 1 xor x
        dp[x][2] = (dp[x][2] + dp[x][1]) % modulo
        dp[x][1] = (dp[x][1] + dp[y][1] + dp[y][2] + 1) % modulo
    }
    return dp.sumOf { it.sum() }.mod(modulo)
}