package cn_solution

fun maxHeight(cuboids: Array<IntArray>): Int {
    cuboids.forEach { it.sort() }
    cuboids.sortWith(compareBy({ it[2] }, { it[1] }, { it[0] }))
    val dp = IntArray(cuboids.size)
    var result = 0
    for (i in cuboids.indices) {
        for (j in 0 until i)
            if (cuboids[j][0] <= cuboids[i][0] && cuboids[j][1] <= cuboids[i][1])
                dp[i] = maxOf(dp[i], dp[j])
        dp[i] += cuboids[i][2]
        result = maxOf(result, dp[i])
    }
    return result
}