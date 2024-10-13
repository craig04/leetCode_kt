package cn_solution

fun superEggDrop(k: Int, n: Int): Int {
    val dp = IntArray(n + 1) { it }
    for (i in 2..k) {
        var last = dp[0]
        for (j in 1..n) {
            val curr = dp[j]
            dp[j] = dp[j - 1] + 1 + last
            if (dp[j] >= n)
                break
            last = curr
        }
    }
    return (1..n).first { dp[it] >= n }
}