package cn_solution

private fun longestPalindrome(s: String, t: String): Int {
    val a = s.toCharArray()
    val b = t.toCharArray()
    val n = a.size
    val m = b.size
    val dp = Array(n + 1) { IntArray(m + 1) }
    val x = IntArray(n + 1)
    val y = IntArray(m + 1)
    for (i in 1..n)
        for (j in m - 1 downTo 0)
            if (a[i - 1] == b[j]) {
                dp[i][j] = dp[i - 1][j + 1] + 1
                x[i] = maxOf(x[i], dp[i][j])
                y[m - j] = maxOf(y[m - j], dp[i][j])
            }
    fun calc(str: CharArray, pre: IntArray): Int {
        val len = str.size
        return (0 until str.size * 2).maxOf {
            var l = it / 2
            var r = it - l
            while (l >= 0 && r < len && str[l] == str[r]) {
                l--
                r++
            }
            r - l - 1 + pre[l + 1] * 2
        }
    }
    return maxOf(calc(a, x), calc(b.apply { reverse() }, y))
}