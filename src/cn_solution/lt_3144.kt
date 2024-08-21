package cn_solution

fun minimumSubstringsInPartition(s: String): Int {
    val n = s.length
    val dp = IntArray(n + 1) { it }
    dp[0] = 0
    val cnt = IntArray(26)
    for (i in s.indices) {
        cnt.fill(0)
        var cat = 0
        var max = 0
        for (j in i downTo 0) {
            val idx = s[j] - 'a'
            if (++cnt[idx] == 1)
                cat++
            max = maxOf(max, cnt[idx])
            if (max * cat == i - j + 1)
                dp[i + 1] = minOf(dp[i + 1], dp[j] + 1)
        }
    }
    return dp[n]
}