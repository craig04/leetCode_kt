package cn_solution

fun numRollsToTarget(n: Int, k: Int, target: Int): Int {
    val dp = IntArray(target + 1)
    dp[0] = 1
    repeat(n) {
        for (m in target downTo 0)
            dp[m] = (maxOf(0, m - k) until m).fold(0) { num, t ->
                (num + dp[t]) % 1000000007
            }
    }
    return dp[target]
}