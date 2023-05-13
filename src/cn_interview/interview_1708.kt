package cn_interview

@Suppress("ObjectLiteralToLambda")
fun bestSeqAtIndex(height: IntArray, weight: IntArray): Int {
    val n = height.size
    val worker = Array(n) { Pair(height[it], weight[it]) }
    worker.sortWith(object : Comparator<Pair<Int, Int>> {
        override fun compare(l: Pair<Int, Int>, r: Pair<Int, Int>): Int {
            val diff = l.first - r.first
            return if (diff == 0) r.second - l.second else diff
        }
    })
    val dp = IntArray(n)
    return worker.fold(0) { pos, (_, w) ->
        var l = 0
        var r = pos
        while (l != r) {
            val m = (l + r) shr 1
            when (dp[m] < w) {
                true -> l = m + 1
                else -> r = m
            }
        }
        dp[l] = w
        maxOf(pos, l + 1)
    }
}