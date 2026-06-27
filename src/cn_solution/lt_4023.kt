package cn_solution

fun elevatorRequests(n: Int, start: Int, requests: IntArray): Long {
    val a = requests.toMutableList()
    if (start !in requests)
        a.add(start)
    a.sort()
    val pos = a.indexOf(start)
    val m = a.size
    val dp = Array(m) { Array(m) { LongArray(2) { 1L shl 50 } } }
    dp[pos][pos].fill(0)
    for (len in 2..m) {
        for (i in 0..m - len) {
            val j = i + len - 1
            val cnt = m - len + 1L
            dp[i][j][0] = minOf(
                dp[i + 1][j][0] + cnt * (a[i + 1] - a[i]),
                dp[i + 1][j][1] + cnt * (a[j] - a[i])
            )
            dp[i][j][1] = minOf(
                dp[i][j - 1][0] + cnt * (a[j] - a[i]),
                dp[i][j - 1][1] + cnt * (a[j] - a[j - 1])
            )
        }
    }
    return dp[0][m - 1].min()
}