package cn_solution

fun minExtraChar(s: String, dictionary: Array<String>): Int {
    val mod = 9999983
    val dict = dictionary.mapTo(HashSet()) {
        it.fold(0) { hash, c -> (hash * 31 + (c - 'a' + 1)) % mod }
    }
    val n = s.length
    val dp = IntArray(n + 1)
    for (i in 1..n) {
        var hash = 0
        var temp = 1
        dp[i] = (i - 1 downTo 0).minOf { j ->
            hash = (hash + (s[j] - 'a' + 1) * temp) % mod
            temp = temp * 31 % mod
            if (hash in dict)
                dp[j]
            else
                dp[j] + i - j
        }
    }
    return dp[n]
}