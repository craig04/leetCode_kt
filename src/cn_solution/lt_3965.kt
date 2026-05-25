package cn_solution

fun finishTime(n: Int, edges: Array<IntArray>, baseTime: IntArray): Long {
    val g = Array(n) { ArrayList<Int>() }
    for ((u, v) in edges)
        g[u].add(v)
    fun dfs(u: Int): Long {
        if (g[u].isEmpty())
            return baseTime[u] + 0L
        var latest = Long.MIN_VALUE
        var earliest = Long.MAX_VALUE
        for (v in g[u]) {
            val x = dfs(v)
            latest = maxOf(latest, x)
            earliest = minOf(earliest, x)
        }
        return latest * 2 - earliest + baseTime[u]
    }
    return dfs(0)
}