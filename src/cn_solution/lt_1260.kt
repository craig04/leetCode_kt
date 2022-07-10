package cn_solution

fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {
    val n = grid.size
    val m = grid[0].size
    val elements = n * m
    val result = Array(n) { IntArray(m) }
    for (i in 0 until n) {
        for (j in 0 until m) {
            val index = (i * m + j + k) % elements
            result[index / m][index % m] = grid[i][j]
        }
    }
    return result.map { it.asList() }
}