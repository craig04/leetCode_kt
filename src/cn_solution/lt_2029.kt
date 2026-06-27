package cn_solution

import kotlin.math.abs

fun stoneGameIX(stones: IntArray): Boolean {
    val cnt = IntArray(3)
    for (s in stones)
        cnt[s % 3]++
    return if (cnt[0] % 2 == 0)
        minOf(cnt[1], cnt[2]) >= 1
    else
        abs(cnt[1] - cnt[2]) > 2
}