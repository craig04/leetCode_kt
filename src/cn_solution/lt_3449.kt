package cn_solution

private fun maxScore(points: IntArray, m: Int): Long {
    var l = 1L
    var r = Long.MAX_VALUE shr 16
    while (l < r) {
        val mid = (l + r + 1) shr 1
        var cnt = 0L
        var pre = 0L
        for (i in points.indices) {
            var req = (mid + points[i] - 1) / points[i] - pre
            if (i == points.lastIndex && req <= 0)
                break
            req = maxOf(req, 1)
            cnt += req * 2 - 1
            if (cnt > m)
                break
            pre = req - 1
        }
        if (cnt > m)
            r = mid - 1
        else
            l = mid
    }
    return l
}