package cn_solution

fun maximumDetonation(bombs: Array<IntArray>): Int {
    fun pow(n: Int) = 1L * n * n
    val n = bombs.size
    val g = Array(n) { ArrayList<Int>() }
    for (i in bombs.indices) {
        val (x, y, z) = bombs[i]
        for (j in bombs.indices) {
            if (i == j)
                continue
            val (a, b) = bombs[j]
            if (pow(x - a) + pow(y - b) <= pow(z))
                g[i].add(j)
        }
    }
    val vis = BooleanArray(n)
    fun dfs(i: Int): Int {
        if (vis[i])
            return 0
        vis[i] = true
        return 1 + g[i].sumOf { dfs(it) }
    }
    return bombs.indices.maxOf { i ->
        vis.fill(false)
        dfs(i)
    }
}