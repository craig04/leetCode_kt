package cn_solution

fun countArrangement(n: Int): Int {
    val dp = IntArray(1 shl n)
    dp[0] = 1
    for (s in 1 until dp.size) {
        val i = s.countOneBits()
        for (j in 1..n)
            if (1.shl(j - 1).and(s) != 0 && (i % j == 0 || j % i == 0))
                dp[s] += dp[1.shl(j - 1).xor(s)]
    }
    return dp.last()
}