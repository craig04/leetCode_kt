package cn_lcr

fun minFlipsMonoIncr(s: String): Int {
    var dp1 = 0
    var dp0 = 0
    for (c in s) {
        dp1 = '0' - c + 1 + minOf(dp0, dp1)
        dp0 += c - '0'
    }
    return minOf(dp0, dp1)
}