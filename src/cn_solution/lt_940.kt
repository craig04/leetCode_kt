package cn_solution

fun distinctSubseqII(s: String): Int {
    val modulo = 1000000007
    var result = 0L
    val dp = LongArray(26)
    for (c in s) {
        val temp = dp[c - 'a']
        dp[c - 'a'] = (result + 1) % modulo
        result = (result + dp[c - 'a'] - temp + modulo) % modulo
    }
    return result.toInt()
}