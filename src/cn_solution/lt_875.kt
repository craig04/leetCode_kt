package cn_solution

fun minEatingSpeed(piles: IntArray, h: Int): Int {
    var l = 1
    var r = piles.fold(0) { acc, p -> maxOf(acc, p) }
    while (l != r) {
        val m = (l + r) shr 1
        val hours = piles.sumBy { (it + m - 1) / m }
        if (hours <= h) {
            r = m
        } else {
            l = m + 1
        }
    }
    return r
}