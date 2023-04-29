package cn_solution

fun partition(s: String): List<List<String>> {
    val n = s.length
    val palindrome = Array(n) { BooleanArray(n + 1) }
    val dp = Array(n + 1) { ArrayList<List<String>>() }
    dp[n].add(emptyList())
    for (i in 0 until n)
        for (j in i + 1..n)
            palindrome[i][j] = (0 until (j - i) / 2).all {
                s[i + it] == s[j - it - 1]
            }
    for (i in n - 1 downTo 0)
        for (j in i + 1..n)
            if (palindrome[i][j])
                dp[j].mapTo(dp[i]) {
                    arrayListOf(s.substring(i, j)).apply { addAll(it) }
                }
    return dp[0]
}