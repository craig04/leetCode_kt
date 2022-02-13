package cn_solution

fun numWays(steps: Int, arrLen: Int): Int {
    val re = 1000000007
    val sz = minOf(steps / 2, arrLen - 1) + 3
    val dp = IntArray(sz)
    dp[1] = 1
    repeat(steps) {
        var last = 0
        for (i in 1..sz - 2) {
            var temp = (dp[i] + last) % re
            temp = (temp + dp[i + 1]) % re
            last = dp[i]
            dp[i] = temp
        }
    }
    return dp[1]
}