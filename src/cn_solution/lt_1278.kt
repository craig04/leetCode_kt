package cn_solution

fun palindromePartition(s: String, k: Int): Int {
    val n = s.length
    val modify = Array(n) { IntArray(n) }
    for (i in s.indices) {
        fun calculate(left: Int, right: Int) {
            var l = left
            var r = right
            var cnt = 0
            while (l >= 0 && r < n) {
                if (s[l] != s[r])
                    cnt++
                modify[l--][r++] = cnt
            }
        }
        calculate(i, i)
        calculate(i - 1, i)
    }
    val dp = Array(n + 1) { IntArray(k + 1) }
    for (i in 1..n) {
        dp[i][1] = modify[0][i - 1]
        for (j in 2..minOf(i, k)) {
            dp[i][j] = (j - 1 until i).minOf { dp[it][j - 1] + modify[it][i - 1] }
        }
    }
    return dp[n][k]
}