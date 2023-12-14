package cn_solution

fun winnerSquareGame(n: Int): Boolean {
    val dp = BooleanArray(n + 1)
    loop@ for (i in 1..n) {
        var k = 1
        do {
            if (!dp[i - k * k]) {
                dp[i] = true
                continue@loop
            }
        } while (++k * k <= i)
    }
    return dp[n]
}