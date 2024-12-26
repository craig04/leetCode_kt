package cn_solution

fun minimumOperations(grid: Array<IntArray>): Int {
    return grid[0].indices.sumOf { j ->
        var pre = Int.MIN_VALUE
        grid.indices.sumOf { i ->
            val cur = maxOf(pre + 1, grid[i][j])
            pre = cur
            cur - grid[i][j]
        }
    }
}