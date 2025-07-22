package cn_solution

fun findItinerary(tickets: List<List<String>>): List<String> {
    val g = HashMap<String, ArrayList<String>>()
    for ((u, v) in tickets)
        g.computeIfAbsent(u) { ArrayList() }.add(v)
    g.values.forEach { it.sortDescending() }
    val ans = ArrayList<String>()
    fun dfs(u: String) {
        val adj = g[u]
        while (!adj.isNullOrEmpty())
            dfs(adj.removeLast())
        ans.add(u)
    }
    dfs("JFK")
    return ans.asReversed()
}