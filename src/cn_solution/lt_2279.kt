package cn_solution

fun maximumBags(capacity: IntArray, rocks: IntArray, additionalRocks: Int): Int {
    val n = capacity.size
    val a = IntArray(n) { capacity[it] - rocks[it] }
    a.sort()
    var pos = 0
    var left = additionalRocks
    while (pos != n && a[pos] <= left)
        left -= a[pos++]
    return pos
}