package cn_solution

fun numBusesToDestination(routes: Array<IntArray>, source: Int, target: Int): Int {
    if (source == target)
        return 0
    val n = routes.size
    val adj = Array(n) { BooleanArray(n) }
    val stations = HashMap<Int, ArrayList<Int>>()
    for (i in routes.indices) {
        for (s in routes[i]) {
            val exist = stations.computeIfAbsent(s) { ArrayList() }
            for (j in exist) {
                adj[i][j] = true
                adj[j][i] = true
            }
            exist.add(i)
        }
    }
    val change = IntArray(n)
    val q = ArrayDeque<Int>()
    for (r in stations[source] ?: emptyList()) {
        change[r] = 1
        q.addLast(r)
    }
    val targetRoutes = stations[target]?.toHashSet() ?: return -1
    while (q.isNotEmpty()) {
        val i = q.removeFirst()
        val c = change[i]
        if (i in targetRoutes)
            return c
        for (j in 0 until n) {
            if (adj[i][j] && change[j] == 0) {
                change[j] = c + 1
                q.addLast(j)
            }
        }
    }
    return -1
}