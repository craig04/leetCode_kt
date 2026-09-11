package cn_solution

fun minimizedMaximum(n: Int, quantities: IntArray): Int {
    var l = 1
    var r = quantities.max()
    while (l != r) {
        val m = (l + r) / 2
        var cnt = 0
        for (q in quantities) {
            cnt += (q + m - 1) / m
            if (cnt > n)
                break
        }
        if (cnt > n)
            l = m + 1
        else
            r = m
    }
    return l
}