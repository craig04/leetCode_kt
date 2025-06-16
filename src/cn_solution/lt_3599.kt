package cn_solution

fun minXor(nums: IntArray, k: Int): Int {
    val n = nums.size
    val x = IntArray(n + 1)
    val dp = Array(n + 1) { IntArray(k + 1) { Int.MAX_VALUE } }
    dp[0][0] = 0
    for (i in 1..n) {
        x[i] = x[i - 1] xor nums[i - 1]
        for (j in 1..minOf(i, k))
            for (t in j - 1..i - 1)
                dp[i][j] = minOf(dp[i][j], maxOf(dp[t][j - 1], x[t] xor x[i]))
    }
    return dp[n][k]
}
