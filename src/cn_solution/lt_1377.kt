package cn_solution

fun frogPosition(n: Int, edges: Array<IntArray>, t: Int, target: Int): Double {
    val adj = Array(n + 1) { ArrayList<Int>() }
    for ((u, v) in edges) {
        adj[u].add(v)
        adj[v].add(u)
    }
    val visit = BooleanArray(n + 1)
    var result = 0.0
    fun dfs(i: Int, prob: Double, t: Int) {
        val next = if (i == 1) adj[i].size else adj[i].size - 1
        if (t == 0 || next == 0) {
            if (i == target)
                result += prob
            return
        }
        visit[i] = true
        val p = prob / next
        adj[i].forEach {
            if (!visit[it])
                dfs(it, p, t - 1)
        }
        visit[i] = false
    }
    dfs(1, 1.0, t)
    return result
}