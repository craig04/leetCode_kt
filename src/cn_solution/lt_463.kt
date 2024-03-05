package cn_solution

fun islandPerimeter(grid: Array<IntArray>): Int {
    val n = grid.size - 1
    val m = grid[0].size - 1
    var perimeter = 0
    for (i in grid.indices)
        for (j in grid[0].indices)
            if (grid[i][j] == 1) {
                perimeter += 4
                if (i > 0 && grid[i - 1][j] == 1)
                    perimeter--
                if (i < n && grid[i + 1][j] == 1)
                    perimeter--
                if (j > 0 && grid[i][j - 1] == 1)
                    perimeter--
                if (j < m && grid[i][j + 1] == 1)
                    perimeter--
            }
    return perimeter
}