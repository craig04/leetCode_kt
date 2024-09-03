package cn_solution

fun maxPossibleScore(start: IntArray, d: Int): Int {
    start.sort()
    var l = 0
    var r = start.max() + d
    while (l != r) {
        val m = (r - l + 1).shr(1) + l
        var pre = start[0]
        var good = true
        for (i in 1 until start.size) {
            if (start[i] + d - m < pre) {
                good = false
                break
            }
            pre = maxOf(start[i], pre + m)
        }
        if (good)
            l = m
        else
            r = m - 1
    }
    return l
}