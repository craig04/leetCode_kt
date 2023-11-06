package cn_lcr

fun partition(s: String): List<List<String>> {
    val n = s.length
    val pal = Array(n) { i -> BooleanArray(n + 1) { j -> j - i <= 1 } }
    for (len in 2..n)
        for (i in len..n)
            pal[i - len][i] = pal[i - len + 1][i - 1] && s[i - len] == s[i - 1]
    val dp = Array(n + 1) { ArrayList<List<String>>() }
    dp[0].add(emptyList())
    for (i in 0..n) {
        for (j in i + 1..n)
            if (pal[i][j])
                dp[i].mapTo(dp[j]) { ArrayList(it).apply { add(s.substring(i, j)) } }
    }
    return dp[n]
}