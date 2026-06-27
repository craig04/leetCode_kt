package cn_solution

private fun maximumSafenessFactor_binarySearch(grid: List<List<Int>>): Int {
    val dir = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val n = grid.size
    val range = 0 until n
    val dis = Array(n) { IntArray(n) { Int.MAX_VALUE } }
    val q = ArrayDeque<IntArray>()
    for (i in grid.indices)
        for (j in grid[i].indices)
            if (grid[i][j] == 1) {
                dis[i][j] = 0
                q.addLast(intArrayOf(i, j))
            }
    while (q.isNotEmpty()) {
        val (x, y) = q.removeFirst()
        for (t in dir.indices.step(2)) {
            val u = x + dir[t]
            val v = y + dir[t + 1]
            if (u in range && v in range && dis[u][v] == Int.MAX_VALUE) {
                dis[u][v] = dis[x][y] + 1
                q.addLast(intArrayOf(u, v))
            }
        }
    }
    var l = 0
    var r = minOf(dis[0][0], dis[n - 1][n - 1])
    val vis = Array(n) { IntArray(n) }
    while (l != r) {
        val m = (l + r + 1) / 2
        fun check(): Boolean {
            val q = ArrayDeque<IntArray>()
            q.addLast(intArrayOf(0, 0))
            while (q.isNotEmpty()) {
                val (x, y) = q.removeFirst()
                for (t in dir.indices.step(2)) {
                    val u = x + dir[t]
                    val v = y + dir[t + 1]
                    if (u in range && v in range && dis[u][v] >= m && vis[u][v] != m) {
                        if (u == n - 1 && v == n - 1)
                            return true
                        vis[u][v] = m
                        q.addLast(intArrayOf(u, v))
                    }
                }
            }
            return false
        }
        if (check())
            l = m
        else
            r = m - 1
    }
    return l
}

private fun maximumSafenessFactor_unionFind(grid: List<List<Int>>): Int {
    val dir = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val n = grid.size
    val range = 0 until n
    val dis = Array(n) { IntArray(n) { Int.MAX_VALUE } }
    val q = ArrayDeque<IntArray>()
    for (i in grid.indices)
        for (j in grid[i].indices)
            if (grid[i][j] == 1) {
                dis[i][j] = 0
                q.addLast(intArrayOf(i, j))
            }
    while (q.isNotEmpty()) {
        val (x, y) = q.removeFirst()
        for (t in dir.indices.step(2)) {
            val u = x + dir[t]
            val v = y + dir[t + 1]
            if (u in range && v in range && dis[u][v] == Int.MAX_VALUE) {
                dis[u][v] = dis[x][y] + 1
                q.addLast(intArrayOf(u, v))
            }
        }
    }
    val adj = Array(2 * n - 1) { ArrayList<IntArray>() }
    for (i in range)
        for (j in range) {
            val pos = i * n + j
            if (i != 0)
                adj[minOf(dis[i][j], dis[i - 1][j])] += intArrayOf(pos, pos - n)
            if (j != 0)
                adj[minOf(dis[i][j], dis[i][j - 1])] += intArrayOf(pos, pos - 1)
        }
    val p = IntArray(n * n) { it }
    fun find(x: Int): Int {
        if (p[x] != x)
            p[x] = find(p[x])
        return p[x]
    }
    for (i in adj.lastIndex downTo 1) {
        for ((x, y) in adj[i]) {
            val u = find(x)
            val v = find(y)
            p[u] = v
        }
        if (find(0) == find(n * n - 1))
            return i
    }
    return 0
}