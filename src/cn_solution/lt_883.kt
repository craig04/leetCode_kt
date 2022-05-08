package cn_solution

fun projectionArea(grid: Array<IntArray>): Int {
    return grid.indices.sumBy { i ->
        var back = 0
        var side = 0
        var bottom = 0
        for (j in grid.indices) {
            bottom += minOf(1, grid[i][j])
            back = maxOf(back, grid[i][j])
            side = maxOf(side, grid[j][i])
        }
        back + side + bottom
    }
}