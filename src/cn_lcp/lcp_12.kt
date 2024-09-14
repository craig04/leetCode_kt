package cn_lcp

fun minTime(time: IntArray, m: Int): Int {
    var l = 1
    var r = Int.MAX_VALUE / 2
    while (l != r) {
        val mid = (l + r) shr 1
        var day = 0
        var i = 0
        while (i != time.size) {
            var sum = 0
            var max = 0
            var j = i
            while (j != time.size && sum + time[j] - maxOf(max, time[j]) <= mid) {
                sum += time[j]
                max = maxOf(max, time[j++])
            }
            if (++day > m)
                break
            i = j
        }
        if (i == time.size)
            r = mid
        else
            l = mid + 1
    }
    return l
}