package cn_solution

import kotlin.math.abs

fun elevatorRequests(n: Int, start: Int, requests: Array<IntArray>): Long {
    val m = requests.size
    val status = 1 shl m
    val dp = Array(status) { LongArray(m) { Long.MAX_VALUE / 2 } }
    for (i in requests.indices) {
        val (a, f) = requests[i]
        dp[1 shl i][i] = 0L + maxOf(a, abs(start - f))
    }
    for (cur in 0 until status) {
        if (cur and (cur - 1) == 0)
            continue
        var x = cur
        while (x != 0) {
            val p = x.takeLowestOneBit()
            val i = p.countTrailingZeroBits()
            val (a, f) = requests[i]
            val pre = p xor cur
            var y = pre
            while (y != 0) {
                val q = y.takeLowestOneBit()
                val j = q.countTrailingZeroBits()
                dp[cur][i] = minOf(
                    dp[cur][i],
                    maxOf(dp[pre][j] + abs(f - requests[j][1]), 0L + a)
                )
                y = y xor q
            }
            x = x xor p
        }
    }
    return dp[status - 1].min()
}