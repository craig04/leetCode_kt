package cn_solution

fun maxDistance(position: IntArray, m: Int): Int {
    position.sort()
    var l = 1
    var r = position.last() - position.first()
    loop@ while (l < r) {
        val mid = (l + r + 1) shr 1
        var pre = position.first()
        var cnt = 1
        for (pos in position) {
            if (pos - pre >= mid) {
                if (++cnt >= m) {
                    l = mid
                    continue@loop
                }
                pre = pos
            }
        }
        r = mid - 1
    }
    return l
}
