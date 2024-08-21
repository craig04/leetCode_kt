package cn_solution

fun satisfiesConditions(grid: Array<IntArray>): Boolean {
    val line = grid[0]
    return line.indices.all { j ->
        val element = line[j]
        (j == 0 || element != line[j - 1]) && grid.indices.all { i ->
            grid[i][j] == element
        }
    }
}