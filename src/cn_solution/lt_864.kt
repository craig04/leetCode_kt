package cn_solution

fun shortestPathAllKeys(grid: Array<String>): Int {
    val d = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val n = grid.size
    val m = grid[0].length
    var numOfKeys = 0
    var (sx, sy) = IntArray(2)
    for (i in 0 until n)
        for (j in 0 until m)
            if (grid[i][j] == '@') {
                sx = i
                sy = j
            } else if (grid[i][j] in 'a'..'z') {
                numOfKeys++
            }
    val q = ArrayDeque<IntArray>()
    val dp = Array(n) { Array(m) { IntArray(1 shl numOfKeys) { -1 } } }
    q.addLast(intArrayOf(sx, sy, 0))
    dp[sx][sy][0] = 0
    while (q.isNotEmpty()) {
        val (x, y, keys) = q.removeFirst()
        if (keys.countOneBits() == numOfKeys)
            return dp[x][y][keys]
        for (i in d.indices.step(2)) {
            val a = x + d[i]
            val b = y + d[i + 1]
            if (a !in 0 until n ||
                b !in 0 until m ||
                grid[a][b] == '#' ||
                grid[a][b] in 'A'..'Z' && keys.shr(grid[a][b] - 'A').and(1) == 0
            )
                continue
            var next = keys
            if (grid[a][b] in 'a'..'z')
                next = 1.shl(grid[a][b] - 'a').or(keys)
            if (dp[a][b][next] == -1) {
                dp[a][b][next] = dp[x][y][keys] + 1
                q.addLast(intArrayOf(a, b, next))
            }
        }
    }
    return -1
}