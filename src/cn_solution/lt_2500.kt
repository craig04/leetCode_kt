package cn_solution

fun deleteGreatestValue(grid: Array<IntArray>): Int {
    grid.forEach { it.sort() }
    return (0 until grid[0].size).sumBy { j ->
        grid.indices.fold(Int.MIN_VALUE) { max, i -> maxOf(max, grid[i][j]) }
    }
}