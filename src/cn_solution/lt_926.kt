package cn_solution

fun minFlipsMonoIncr(s: String): Int {
    var dp0 = 0
    var dp1 = 0
    for (c in s) {
        val temp = dp0
        dp0 += c - '0'
        dp1 = '0' - c + 1 + minOf(temp, dp1)
    }
    return minOf(dp0, dp1)
}