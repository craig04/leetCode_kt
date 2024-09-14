package cn_solution

fun highestPeak(isWater: Array<IntArray>): Array<IntArray> {
    val n = isWater.size
    val m = isWater.first().size
    val row = 0 until n
    val col = 0 until m
    val d = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val h = Array(n) { IntArray(m) { -1 } }
    val q = ArrayDeque<Int>()
    for (i in row)
        for (j in col)
            if (isWater[i][j] == 1) {
                h[i][j] = 0
                q.addLast(i * m + j)
            }
    while (q.isNotEmpty()) {
        val pos = q.removeFirst()
        val i = pos / m
        val j = pos % m
        for (t in d.indices.step(2)) {
            val u = i + d[t]
            val v = j + d[t + 1]
            if (u in row && v in col && h[u][v] == -1) {
                h[u][v] = h[i][j] + 1
                q.addLast(u * m + v)
            }
        }
    }
    return h
}