package cn_solution

fun matrixScore(grid: Array<IntArray>): Int {
    val n = grid.size
    val m = grid[0].size
    var ans = 0
    var bit = 1
    for (i in m - 1 downTo 0) {
        val cnt = grid.sumOf { it[i] xor it[0] xor 1 }
        ans += maxOf(cnt, n - cnt) * bit
        bit *= 2
    }
    return ans
}