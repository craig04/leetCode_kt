package cn_solution

fun possibleStringCount(word: String, k: Int): Int {
    val modulo = 1000000007
    val n = word.length
    val freq = ArrayList<Int>()
    var ans = 1
    var i = 0
    while (i != n) {
        var j = i + 1
        while (j != n && word[j] == word[i])
            j++
        val len = j - i
        freq.add(len)
        ans = (ans * 1L * len).mod(modulo)
        i = j
    }
    if (freq.size >= k)
        return ans % modulo
    val dp = IntArray(k) { 1 }
    for (f in freq) {
        for (i in k - 1 downTo 1) {
            dp[i] = dp[i - 1] + modulo
            if (i > f)
                dp[i] -= dp[i - f - 1]
            dp[i] %= modulo
        }
        dp[0] = 0
        for (i in 1 until k)
            dp[i] = (dp[i] + dp[i - 1]) % modulo
    }
    return (ans + modulo - dp[k - 1]) % modulo
}