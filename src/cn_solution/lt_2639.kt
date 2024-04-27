package cn_solution

import kotlin.math.absoluteValue
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.sign

fun findColumnWidth(grid: Array<IntArray>): IntArray {
    return IntArray(grid[0].size) { i ->
        grid.maxOf {
            if (it[i] == 0)
                1
            else
                floor(log10(it[i].absoluteValue.toDouble())).toInt() + 1 - minOf(0, it[i].sign)
        }
    }
}