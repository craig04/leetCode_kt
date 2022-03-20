package cn_solution

fun findBall(grid: Array<IntArray>): IntArray {
    val col = grid[0].size
    return IntArray(col) {
        var pos = it
        for (row in grid) {
            val temp = pos + row[pos]
            if (temp == -1 || temp == col || row[pos] != row[temp]) {
                return@IntArray -1
            }
            pos = temp
        }
        pos
    }
}