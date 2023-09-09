package cn_solution

fun collectTheCoins(coins: IntArray, edges: Array<IntArray>): Int {
    if (coins.sum() <= 1)
        return 0
    val n = coins.size
    val adj = Array(n) { HashSet<Int>() }
    val degree = IntArray(n)
    var edge = n - 1
    edges.forEach { (u, v) ->
        adj[u].add(v)
        adj[v].add(u)
        degree[u]++
        degree[v]++
    }
    fun crop(recursive: Boolean = false, predicate: (Int) -> Boolean = { true }) {
        val q = (0 until n).filterTo(ArrayDeque()) { degree[it] == 1 }
        while (q.isNotEmpty()) {
            val u = q.removeFirst()
            if (predicate(u)) {
                val iterator = adj[u].iterator()
                while (iterator.hasNext()) {
                    val v = iterator.next()
                    --edge
                    if (--degree[v] == 1 && recursive)
                        q.addLast(v)
                    iterator.remove()
                    adj[v].remove(u)
                }
            }
        }
    }
    crop(true) { coins[it] == 0 }
    crop()
    crop()
    return edge * 2
}