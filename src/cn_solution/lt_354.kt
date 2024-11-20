package cn_solution

fun maxEnvelopes(envelopes: Array<IntArray>): Int {
    envelopes.sortWith(compareBy({ it[0] }, { -it[1] }))
    val dp = IntArray(envelopes.size + 1) { Int.MAX_VALUE }
    var len = 0
    for (i in envelopes.indices) {
        var l = 0
        var r = len
        while (l < r) {
            val m = (l + r) shr 1
            if (envelopes[i][1] > dp[m])
                l = m + 1
            else
                r = m
        }
        dp[l] = envelopes[i][1]
        len = maxOf(len, l + 1)
    }
    return len
}