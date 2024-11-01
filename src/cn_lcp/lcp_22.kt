package cn_lcp

fun paintingPlan(n: Int, k: Int): Int {
    if (k == n * n)
        return 1
    val c = Array(n + 1) { IntArray(n + 1) { 1 } }
    for (i in 1..n)
        for (j in 1 until i)
            c[i][j] = c[i - 1][j - 1] + c[i - 1][j]
    var ans = 0
    for (i in 0 until n)
        for (j in 0 until n)
            if (i * n + j * n - i * j == k)
                ans += c[n][i] * c[n][j]
    return ans
}