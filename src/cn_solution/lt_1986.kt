package cn_solution

fun minSessions(tasks: IntArray, sessionTime: Int): Int {
    val n = tasks.size
    val s = 1 shl n
    val f = BooleanArray(s)
    loop@ for (i in 1 until s) {
        var t = 0
        for (j in 0 until n)
            if (1 shl j and i != 0) {
                t += tasks[j]
                if (t > sessionTime)
                    continue@loop
            }
        f[i] = true
    }
    val dp = IntArray(s)
    for (i in 1 until s) {
        dp[i] = Int.MAX_VALUE
        var j = i
        while (j != 0) {
            if (f[j])
                dp[i] = minOf(dp[i], dp[i xor j] + 1)
            j = (j - 1) and i
        }
    }
    return dp[s - 1]
}