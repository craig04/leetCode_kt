package cn_solution

fun countWinningSequences(s: String): Int {
    val modulo = 1000000007
    val table = Array(26) { IntArray(26) }
    val moves = "FWE"
    for (i in moves.indices) {
        val x = moves[i] - 'A'
        val y = moves[(i + 1) % 3] - 'A'
        table[x][y] = -1
        table[y][x] = 1
    }
    fun score(bob: Char, alice: Char): Int {
        return table[bob - 'A'][alice - 'A']
    }

    val n = s.length
    val dp = Array(n) { Array(3) { IntArray(n * 2 + 1) } }
    for (j in moves.indices)
        dp[0][j][n + score(moves[j], s[0])] = 1
    for (i in 1 until n) {
        for (j in moves.indices) {
            val diff = score(moves[j], s[i])
            val low = if (diff == -1) 1 else 0
            val high = if (diff == 1) 2 * n - 1 else 2 * n
            val last = dp[i - 1]
            for (k in low..high)
                dp[i][j][k + diff] = (last[(j + 1) % 3][k] + last[(j + 2) % 3][k]) % modulo
        }
    }
    var ans = 0
    for (j in moves.indices)
        for (k in n + 1..2 * n)
            ans = (ans + dp[n - 1][j][k]) % modulo
    return ans
}