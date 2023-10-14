package cn_lcr

fun minimumTotal(triangle: List<List<Int>>): Int {
    val dp = IntArray(triangle.size + 1) { Int.MAX_VALUE }
    dp[1] = 0
    for (list in triangle) {
        for (i in list.indices.reversed())
            dp[i + 1] = minOf(dp[i + 1], dp[i]) + list[i]
    }
    return dp.min()
}