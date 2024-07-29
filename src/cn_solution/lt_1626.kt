package cn_solution

fun bestTeamScore(scores: IntArray, ages: IntArray): Int {
    val n = scores.size
    val players = Array(n) { intArrayOf(scores[it], ages[it]) }
    players.sortWith(compareBy({ it[1] }, { it[0] }))
    val dp = IntArray(n + 1)
    for (i in 0 until n) {
        for (j in 0 until i)
            if (players[j][0] <= players[i][0])
                dp[i + 1] = maxOf(dp[i + 1], dp[j + 1])
        dp[i + 1] += players[i][0]
    }
    return dp.max()
}