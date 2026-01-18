package cn_solution

import kotlin.math.abs

fun maxMatrixSum(matrix: Array<IntArray>): Long {
    var cnt = 0
    var sum = 0L
    var min = Int.MAX_VALUE
    for (row in matrix)
        for (num in row) {
            if (num < 0)
                cnt++
            val abs = abs(num)
            sum += abs
            min = minOf(min, abs)
        }
    return if (cnt % 2 == 0) sum else sum - 2 * min
}