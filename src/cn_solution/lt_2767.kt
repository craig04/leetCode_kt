package cn_solution

fun minimumBeautifulSubstrings(s: String): Int {
    val set = hashSetOf(1, 5, 25, 125, 625, 3125, 15625)
    val n = s.length
    val dp = IntArray(n + 1) { n + 1 }
    dp[n] = 0
    for (i in s.indices.reversed()) {
        if (s[i] == '0')
            continue
        var num = 0
        for (j in i until n) {
            num = s[j] - '0' + num * 2
            if (num in set)
                dp[i] = minOf(dp[i], dp[j + 1] + 1)
        }
    }
    return if (dp[0] > n) -1 else dp[0]
}