package cn_lcp

fun getTriggerTime(increase: Array<IntArray>, requirements: Array<IntArray>): IntArray {
    val n = increase.size
    val property = Array(n + 1) { IntArray(3) }
    for (i in increase.indices)
        for (j in 0 until 3)
            property[i + 1][j] = property[i][j] + increase[i][j]
    return IntArray(requirements.size) { idx ->
        val req = requirements[idx]
        var l = 0
        var r = n + 1
        while (l != r) {
            val m = (l + r) shr 1
            if ((0 until 3).all { req[it] <= property[m][it] })
                r = m
            else
                l = m + 1
        }
        if (l == n + 1) -1 else l
    }
}