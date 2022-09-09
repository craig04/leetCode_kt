package cn_solution

fun orangesRotting(grid: Array<IntArray>): Int {
    val n = grid.size
    val m = grid[0].size
    val r = n - 1
    val c = m - 1
    val q = ArrayDeque<Int>()
    for (i in 0 until n)
        for (j in 0 until m)
            if (grid[i][j] == 2)
                q.add(i * m + j)
    fun rot(i: Int, j: Int): Boolean {
        if (grid[i][j] == 1) {
            grid[i][j] = 2
            q.addLast(i * m + j)
            return true
        }
        return false
    }

    var time = 0
    while (!q.isEmpty()) {
        var f = false
        repeat(q.size) {
            val code = q.removeFirst()
            val i = code / m
            val j = code - i * m
            f = f.or(i != 0 && rot(i - 1, j))
            f = f.or(i != r && rot(i + 1, j))
            f = f.or(j != 0 && rot(i, j - 1))
            f = f.or(j != c && rot(i, j + 1))
        }
        if (f) time++
    }
    return if (grid.any { row -> row.any { it == 1 } }) -1 else time
}