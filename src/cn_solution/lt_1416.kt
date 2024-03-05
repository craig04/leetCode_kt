package cn_solution

fun numberOfArrays(s: String, k: Int): Int {
    val modulo = 1000000007
    val dp = IntArray(s.length + 1)
    dp[s.length] = 1
    for (i in s.indices.reversed()) {
        if (s[i] == '0')
            continue
        var num = 0L
        for (j in i until s.length) {
            num = s[j] - '0' + num * 10
            if (num > k)
                break
            dp[i] = (dp[i] + dp[j + 1]) % modulo
        }
    }
    return dp[0]
}