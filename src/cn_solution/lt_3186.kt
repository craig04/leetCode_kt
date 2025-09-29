package cn_solution

fun maximumTotalDamage(power: IntArray): Long {
    power.sort()
    val n = power.size
    var i = 0
    var j = 0
    val dp = LongArray(n + 1)
    while (j != n) {
        val p = power[j]
        var k = j
        while (k != n && power[k] == p)
            k++
        dp[k] = (k - j + 0L) * p
        while (power[i] + 2 < p)
            i++
        dp[k] = maxOf(dp[k] + dp[i], dp[j])
        j = k
    }
    return dp[n]
}