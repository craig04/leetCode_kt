package cn_solution

fun largestLocal(grid: Array<IntArray>): Array<IntArray> {
    return Array(grid.size - 2) { i ->
        IntArray(grid.size - 2) { j ->
            (0 until 9).fold(0) { acc, t ->
                maxOf(acc, grid[i + t / 3][j + t % 3])
            }
        }
    }
}