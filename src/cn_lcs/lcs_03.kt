package cn_lcs

fun largestArea(grid: Array<String>): Int {
    val d = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val n = grid.size
    val m = grid[0].length
    val vis = Array(n) { BooleanArray(m) }
    fun bfs(x: Int, y: Int): Int {
        if (vis[x][y] || grid[x][y] == '0')
            return 0
        var corridor = false
        var area = 0
        val theme = grid[x][y]
        val q = ArrayDeque<Int>()
        vis[x][y] = true
        q.addLast(x * m + y)
        while (q.isNotEmpty()) {
            area++
            val pos = q.removeFirst()
            val u = pos / m
            val v = pos % m
            for (i in d.indices.step(2)) {
                val r = u + d[i]
                val s = v + d[i + 1]
                if (r !in 0 until n || s !in 0 until m || grid[r][s] == '0') {
                    corridor = true
                    continue
                }
                if (theme != grid[r][s] || vis[r][s])
                    continue
                vis[r][s] = true
                q.addLast(r * m + s)
            }
        }
        println()
        return if (corridor) 0 else area
    }
    return (0 until n).maxOf { i -> (0 until m).maxOf { j -> bfs(i, j) } }
}