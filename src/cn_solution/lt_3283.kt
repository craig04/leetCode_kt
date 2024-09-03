package cn_solution

fun maxMoves(kx: Int, ky: Int, positions: Array<IntArray>): Int {
    val n = positions.size
    val range = 0 until 50
    val d = intArrayOf(-2, -1, -2, 1, -1, -2, -1, 2, 1, -2, 1, 2, 2, -1, 2, 1)
    val dist = Array(n + 1) { Array(50) { IntArray(50) { -1 } } }
    for (i in 0..n) {
        var (x, y) = if (i == n) intArrayOf(kx, ky) else positions[i]
        val q = ArrayDeque<Int>()
        dist[i][x][y] = 0
        q.addFirst(x * 50 + y)
        while (q.isNotEmpty()) {
            val pos = q.removeFirst()
            x = pos / 50
            y = pos % 50
            for (t in d.indices.step(2)) {
                val u = x + d[t]
                val v = y + d[t + 1]
                if (u in range && v in range && dist[i][u][v] == -1) {
                    dist[i][u][v] = dist[i][x][y] + 1
                    q.addLast(u * 50 + v)
                }
            }
        }
    }
    val dp = Array(1.shl(n)) { IntArray(n + 1) }
    for (i in 1 until dp.size) {
        val alice = (n - i.countOneBits()) and 1 == 0
        for (j in 0..n) {
            var opt = if (alice) Int.MIN_VALUE else Int.MAX_VALUE
            for (k in 0 until n) {
                if (1.shl(k).and(i) == 0)
                    continue
                var moves = dist[j][positions[k][0]][positions[k][1]]
                moves += dp[1.shl(k).xor(i)][k]
                opt = if (alice)
                    maxOf(opt, moves)
                else
                    minOf(opt, moves)
            }
            dp[i][j] = opt
        }
    }
    return dp.last()[n]
}