package cn_solution

fun racecar(target: Int): Int {
    val dp = IntArray(target + 1)
    for (i in 1..target) {
        val right = i.takeHighestOneBit() * 2 - 1
        val steps = right.countOneBits()
        if (right == i) {
            dp[i] = steps
        } else {
            dp[i] = steps + dp[right - i] + 1
            val left = right / 2
            for (k in 0..steps - 2)
                dp[i] = minOf(dp[i], steps + k + 1 + dp[1.shl(k) - 1 + i - left])
        }
    }
    return dp[target]
}