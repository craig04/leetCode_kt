package cn_solution

fun maxPalindromes(s: String, k: Int): Int {
    fun isPalindrome(l: Int, r: Int): Boolean {
        var x = l
        var y = r
        while (x < y)
            if (s[x++] != s[y--])
                return false
        return true
    }

    val n = s.length
    val dp = IntArray(n + 1)
    for (j in k..n) {
        dp[j] = dp[j - 1]
        if (isPalindrome(j - k, j - 1))
            dp[j] = maxOf(dp[j], dp[j - k] + 1)
        if (j > k && isPalindrome(j - k - 1, j - 1))
            dp[j] = maxOf(dp[j], dp[j - k - 1] + 1)
    }
    return dp[n]
}