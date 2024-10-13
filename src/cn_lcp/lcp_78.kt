package cn_lcp

fun rampartDefensiveLine(rampart: Array<IntArray>): Int {
    val n = rampart.size
    val gaps = IntArray(n - 1)
    var total = 0
    for (i in 0 until n - 1) {
        gaps[i] = rampart[i + 1][0] - rampart[i][1]
        total += gaps[i]
    }
    var l = 0
    var r = total / (n - 2)
    while (l != r) {
        val m = (l + r + 1) shr 1
        var left = 1000000000
        if (gaps.all {
                left = it - maxOf(0, m - left)
                left >= 0
            })
            l = m
        else
            r = m - 1
    }
    return l
}