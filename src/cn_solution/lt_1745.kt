package cn_solution

fun checkPartitioning(s: String): Boolean {
    val n = s.length
    val pal = Array(n) { ArrayList<Int>() }
    for (i in s.indices) {
        var a = i
        var b = i
        while (a >= 0 && b < n && s[a] == s[b])
            pal[a--].add(b++)
        a = i - 1
        b = i
        while (a >= 0 && b < n && s[a] == s[b])
            pal[a--].add(b++)
    }
    val dp = Array(n + 1) { BooleanArray(4) }
    dp[0][0] = true
    for (i in 0 until n)
        for (j in pal[i])
            for (t in 0..2)
                dp[j + 1][t + 1] = dp[j + 1][t + 1] || dp[i][t]
    return dp[n + 1][3]
}