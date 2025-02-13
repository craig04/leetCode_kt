package cn_solution

fun findBall(grid: Array<IntArray>): IntArray {
    val col = grid[0].size
    return IntArray(col) {
        grid.fold(it) { pre, row ->
            val cur = pre + row[pre]
            if (cur !in 0 until col || row[cur] != row[pre])
                return@IntArray -1
            cur
        }
    }
}