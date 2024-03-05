package cn_solution

fun countWays(ranges: Array<IntArray>): Int {
    ranges.sortBy { it[0] }
    var right = ranges[0][1]
    var result = 1
    val modulo = 1000000007
    for (j in ranges.indices) {
        if (ranges[j][0] > right)
            result = result * 2 % modulo
        right = maxOf(right, ranges[j][1])
    }
    return result * 2 % modulo
}