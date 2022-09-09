package cn_solution

fun minimumTotal(triangle: List<List<Int>>): Int {
    val dp = IntArray(triangle.size)
    for (list in triangle) {
        var last = dp[0]
        dp[0] += list[0]
        for (i in 1 until list.lastIndex) {
            val temp = dp[i]
            dp[i] = minOf(dp[i], last) + list[i]
            last = temp
        }
        dp[list.lastIndex] = last + list.last()
    }
    return dp.min() ?: 0
}