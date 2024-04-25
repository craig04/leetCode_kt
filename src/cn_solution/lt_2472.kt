package cn_solution

fun maxPalindromes(s: String, k: Int): Int {
    val n = s.length
    val p = Array(n) { BooleanArray(n) }
    fun init(left: Int, right: Int) {
        var a = left
        var b = right
        while (a >= 0 && b < n) {
            if (s[a] != s[b])
                break
            p[a--][b++] = true
        }
    }
    for (i in s.indices) {
        init(i, i)
        init(i - 1, i)
    }
    val dp = IntArray(n + 1)
    for (i in n - k downTo 0) {
        dp[i] = (i + k..n).fold(dp[i + 1]) { acc, j ->
            if (p[i][j - 1]) maxOf(acc, dp[j] + 1) else acc
        }
    }
    return dp[0]
}