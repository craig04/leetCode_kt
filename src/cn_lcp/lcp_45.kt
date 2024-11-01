package cn_lcp

fun bicycleYard(position: IntArray, terrain: Array<IntArray>, obstacle: Array<IntArray>): Array<IntArray> {
    val d = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val n = terrain.size
    val m = terrain[0].size
    val (a, b) = position
    val dp = Array(n) { Array(m) { BooleanArray(102) } }
    dp[a][b][1] = true
    val q = ArrayDeque<IntArray>()
    q.add(intArrayOf(a, b, 1))
    while (q.isNotEmpty()) {
        val (x, y, z) = q.removeFirst()
        for (t in d.indices.step(2)) {
            val u = x + d[t]
            val v = y + d[t + 1]
            if (u !in 0 until n || v !in 0 until m)
                continue
            val w = z + terrain[x][y] - terrain[u][v] - obstacle[u][v]
            if (w > 0 && !dp[u][v][w]) {
                dp[u][v][w] = true
                q.addLast(intArrayOf(u, v, w))
            }
        }
    }
    dp[a][b][1] = false
    val ans = ArrayList<IntArray>()
    for (i in 0 until n)
        for (j in 0 until m)
            if (dp[i][j][1])
                ans.add(intArrayOf(i, j))
    return ans.toTypedArray()
}