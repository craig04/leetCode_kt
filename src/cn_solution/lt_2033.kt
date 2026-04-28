package cn_solution

import kotlin.math.absoluteValue

private fun minOperations(grid: Array<IntArray>, x: Int): Int {
    val n = grid.size
    val m = grid.first().size
    val arr = IntArray(n * m)
    for (i in 0 until n)
        for (j in 0 until m)
            arr[i * m + j] = grid[i][j]
    arr.sort()
    var ans = 0
    val mid = arr[arr.size / 2]
    for (a in arr) {
        if ((a - arr[0]) % x != 0)
            return -1
        ans += (mid - a).absoluteValue / x
    }
    return ans
}