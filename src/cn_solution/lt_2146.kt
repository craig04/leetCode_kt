package cn_solution

fun highestRankedKItems(grid: Array<IntArray>, pricing: IntArray, start: IntArray, k: Int): List<List<Int>> {
    val dir = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val n = grid.size
    val m = grid.first().size
    val vis = Array(n) { BooleanArray(m) }
    val q = ArrayDeque<IntArray>()
    start.let { (x, y) ->
        vis[x][y] = true
        q.add(intArrayOf(x, y, 0, grid[x][y]))
    }
    val items = ArrayList<IntArray>()
    val budget = pricing.let { (low, high) -> low..high }
    while (q.isNotEmpty()) {
        val (x, y, dis, price) = q.removeFirst()
        if (items.size >= k && dis > items.last()[2])
            break
        if (price in budget)
            items.add(intArrayOf(x, y, dis, price))
        for (t in dir.indices.step(2)) {
            val u = x + dir[t]
            val v = y + dir[t + 1]
            if (u in 0 until n && v in 0 until m && grid[u][v] != 0 && !vis[u][v]) {
                vis[u][v] = true
                q.addLast(intArrayOf(u, v, dis + 1, grid[u][v]))
            }
        }
    }
    items.sortWith(compareBy({ it[2] }, { it[3] }, { it[0] }, { it[1] }))
    return items.take(k).map { it.asList().subList(0, 2) }
}