package cn_solution

fun firstDayBeenInAllRooms(nextVisit: IntArray): Int {
    val modulo = 1000000007
    val n = nextVisit.size
    val dp = LongArray(n)
    for (i in 1 until n) {
        dp[i] = (dp[i - 1] * 2 + modulo - dp[nextVisit[i - 1]] + 2) % modulo
    }
    return dp[n - 1].toInt()
}