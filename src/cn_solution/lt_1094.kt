package cn_solution

fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
    val diff = IntArray(1001)
    for ((num, from, to) in trips) {
        diff[from] += num
        diff[to] -= num
    }
    var cur = 0
    return diff.all {
        cur += it
        cur <= capacity
    }
}