package cn_solution

fun countSubmatrices(grid: Array<IntArray>, k: Int): Int {
    val col = IntArray(grid[0].size)
    return grid.sumOf { row ->
        var s = 0
        row.indices.count { j ->
            col[j] += row[j]
            s += col[j]
            s <= k
        }
    }
}