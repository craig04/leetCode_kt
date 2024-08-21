package cn_solution

import kotlin.math.sign

fun canMakeSquare(grid: Array<CharArray>): Boolean {
    val t = arrayOf(intArrayOf(0, 0), intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(1, 1))
    return t.any { (i, j) -> t.sumOf { (x, y) -> (grid[i + x][j + y] - 'B').sign } != 2 }
}