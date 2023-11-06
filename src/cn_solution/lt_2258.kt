package cn_solution

fun maximumMinutes(grid: Array<IntArray>): Int {
    val n = grid.size
    val m = grid[0].size
    val row = grid.indices
    val col = grid[0].indices
    val person = Array(n) { IntArray(m) { Int.MAX_VALUE } }
    val fire = Array(n) { IntArray(m) { Int.MAX_VALUE } }
    val q = ArrayDeque<Int>()
    val d = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    fun bfs(matrix: Array<IntArray>) {
        while (q.isNotEmpty()) {
            val pos = q.removeFirst()
            val i = pos.shr(16)
            val j = pos.and(0xffff)
            val t = matrix[i][j]
            for (k in d.indices step 2) {
                val u = i + d[k]
                val v = j + d[k + 1]
                if (u in row && v in col && grid[u][v] == 0 && matrix[u][v] == Int.MAX_VALUE) {
                    matrix[u][v] = t + 1
                    q.add(u.shl(16).or(v))
                }
            }
        }
    }
    person[0][0] = 0
    q.addLast(0)
    bfs(person)
    for (i in row)
        for (j in col)
            if (grid[i][j] == 1) {
                fire[i][j] = 0
                q.addLast(i.shl(16).or(j))
            }
    bfs(fire)
    val p = person[n - 1][m - 1]
    val f = fire[n - 1][m - 1]
    return when {
        p == Int.MAX_VALUE || p > f -> -1
        f == Int.MAX_VALUE -> 1000000000
        else -> {
            fun Array<IntArray>.a() = this[n - 1][m - 2]
            fun Array<IntArray>.b() = this[n - 2][m - 1]
            val diff = f - p
            if (fire.a() - person.a() > diff || fire.b() - person.b() > diff)
                diff
            else
                diff - 1
        }
    }
}