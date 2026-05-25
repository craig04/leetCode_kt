package cn_solution

fun largestAltitude(gain: IntArray): Int {
    var x = 0
    return gain.maxOf {
        x += it
        x
    }.coerceAtLeast(0)
}