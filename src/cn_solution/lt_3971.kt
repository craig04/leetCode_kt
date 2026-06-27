package cn_solution

fun maxTotalValue(value: IntArray, decay: IntArray, m: Int): Int {
    var l = 0
    var r = value.max()
    while (l != r) {
        val mid = (l + r + 1) / 2
        var left = m
        for (i in value.indices) {
            val v = value[i]
            if (v >= mid)
                left -= (v - mid) / decay[i] + 1
            if (left < 0)
                break
        }
        if (left < 0)
            l = mid
        else
            r = mid - 1
    }
    var left = m + 0L
    var ans = 0L
    for (i in value.indices) {
        val v = value[i]
        if (v < l)
            continue
        val cnt = (v - l) / decay[i] + 1L
        left -= cnt
        ans += cnt * v - cnt * (cnt - 1) * decay[i] / 2
    }
    return (ans + minOf(0, left) * l).mod(1000000007)
}