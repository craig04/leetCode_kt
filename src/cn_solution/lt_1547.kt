package cn_solution

fun minCost(n: Int, cuts: IntArray): Int {
    val len = cuts.size
    val a = IntArray(len + 2)
    a[1] = n
    cuts.copyInto(a, 2)
    a.sort()
    val dp = Array(len + 2) { IntArray(len + 2) }
    for (j in 1..len) {
        for (i in j downTo 1)
            dp[i][j] = (i..j).minOf { k ->
                dp[i][k - 1] + dp[k + 1][j]
            } + a[j + 1] - a[i - 1]
    }
    return dp[1][len]
}