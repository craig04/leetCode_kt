package cn_solution

fun maximumSafenessFactor(grid: List<List<Int>>): Int {
    val n = grid.size
    val range = grid.indices
    val dist = Array(n) { IntArray(n) { -1 } }
    val dir = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    var head = 0
    var tail = 0
    val qx = IntArray(n * n)
    val qy = IntArray(n * n)
    fun enqueue(x: Int, y: Int) {
        qx[tail] = x
        qy[tail++] = y
    }

    fun init() {
        for (i in range)
            for (j in range)
                if (grid[i][j] == 1) {
                    dist[i][j] = 0
                    enqueue(i, j)
                }
        while (head != tail) {
            val x = qx[head]
            val y = qy[head++]
            for (i in dir.indices step 2) {
                val u = x + dir[i]
                val v = y + dir[i + 1]
                if (u in range && v in range && dist[u][v] == -1) {
                    enqueue(u, v)
                    dist[u][v] = dist[x][y] + 1
                }
            }
        }
    }

    fun check(limit: Int): Boolean {
        head = 0
        tail = 0
        val visit = Array(n) { BooleanArray(n) }
        visit[0][0] = true
        enqueue(0, 0)
        while (head != tail) {
            val x = qx[head]
            val y = qy[head++]
            for (i in dir.indices step 2) {
                val u = x + dir[i]
                val v = y + dir[i + 1]
                if (u in range && v in range && !visit[u][v] && dist[u][v] >= limit) {
                    visit[u][v] = true
                    enqueue(u, v)
                }
            }
        }
        return visit[n - 1][n - 1]
    }
    init()
    var l = 0
    var r = dist[0][0]
    while (l != r) {
        val m = (l + r + 1) shr 1
        when (check(m)) {
            true -> l = m
            else -> r = m - 1
        }
    }
    return r
}