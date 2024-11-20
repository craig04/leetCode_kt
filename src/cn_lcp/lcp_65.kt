package cn_lcp

fun unSuitability(operate: IntArray): Int {
    val n = operate.max() * 2 + 1
    var pre = IntArray(n) { Int.MAX_VALUE }
    var cur = IntArray(n)
    pre[0] = 0
    for (x in operate) {
        cur.fill(Int.MAX_VALUE)
        for (j in 0 until n) {
            if (pre[j] == Int.MAX_VALUE)
                continue
            if (j + x < n)
                cur[j + x] = minOf(cur[j + x], maxOf(pre[j], j + x))
            if (j - x >= 0)
                cur[j - x] = minOf(cur[j - x], pre[j])
            else
                cur[0] = minOf(cur[0], pre[j] - (j - x))
        }
        val tmp = pre
        pre = cur
        cur = tmp
    }
    return pre.min()
}