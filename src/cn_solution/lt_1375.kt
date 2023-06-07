package cn_solution

fun numTimesAllBlue(flips: IntArray): Int {
    var max = 0
    var step = 0
    return flips.count {
        max = maxOf(max, it)
        max == ++step
    }
}