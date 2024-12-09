package cn_solution

import kotlin.math.abs

fun makeStringGood(s: String): Int {
    val cnt = IntArray(26)
    s.forEach { cnt[it - 'a']++ }
    val dp = IntArray(27)
    return (0..cnt.max()).minOf { target ->
        dp.fill(0)
        dp[25] = minOf(cnt[25], abs(cnt[25] - target))
        for (i in 24 downTo 0) {
            val x = cnt[i]
            dp[i] = minOf(x, abs(x - target)) + dp[i + 1]
            val y = cnt[i + 1]
            if (y < target) {
                val z = if (x >= target) target else 0
                dp[i] = minOf(dp[i], maxOf(x - z, target - y) + dp[i + 2])
            }
        }
        dp[0]
    }
}