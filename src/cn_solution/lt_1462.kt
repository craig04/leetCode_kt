package cn_solution

fun checkIfPrerequisite(numCourses: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): List<Boolean> {
    val degree = IntArray(numCourses)
    val adj = Array(numCourses) { ArrayList<Int>() }
    val vis = BooleanArray(numCourses)
    val pre = Array(numCourses) { BooleanArray(numCourses) }
    for ((u, v) in prerequisites) {
        degree[v]++
        adj[u].add(v)
    }
    fun dfs(u: Int) {
        if (vis[u])
            return
        vis[u] = true
        for (v in adj[u]) {
            dfs(v)
            pre[u][v] = true
            for (w in 0 until numCourses)
                if (pre[v][w])
                    pre[u][w] = true
        }
    }
    for (i in 0 until numCourses)
        if (degree[i] == 0)
            dfs(i)
    return queries.map { (u, v) -> pre[u][v] }
}