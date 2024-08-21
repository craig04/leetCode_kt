package cn_solution

fun maximumTotalDamage(power: IntArray): Long {
    power.sort()
    val n = power.size
    var ans = 0L
    var pre = 0L
    var i = -1
    var j = 0
    val dp = LongArray(n + 1)
    while (j != n) {
        val p = power[j]
        var k = j
        while (k != n && power[k] == p)
            k++
        dp[k] = (k - j + 0L) * p
        j = k
        while (power[i + 1] + 2 < p)
            pre = maxOf(pre, dp[++i + 1])
        dp[k] += pre
        ans = maxOf(ans, dp[k])
    }
    return ans
}