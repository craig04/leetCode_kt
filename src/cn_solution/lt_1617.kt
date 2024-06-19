package cn_solution

fun countSubgraphsForEachDiameter(n: Int, edges: Array<IntArray>): IntArray {
    val ans = IntArray(n - 1)
    val adj = Array(n) { ArrayList<Int>() }
    edges.forEach {
        val u = it[0] - 1
        val v = it[1] - 1
        adj[u].add(v)
        adj[v].add(u)
    }
    for (status in 1 until 1.shl(n)) {
        var diameter = 0
        var mask = status
        fun dfs(u: Int): Int {
            mask = 1 shl u xor mask
            var x = 0
            var y = 0
            for (v in adj[u])
                if (1 shl v and mask != 0) {
                    val depth = dfs(v) + 1
                    if (depth > x) {
                        y = x
                        x = depth
                    } else if (depth > y) {
                        y = depth
                    }
                }
            diameter = maxOf(diameter, x + y)
            return x
        }
        dfs(status.countTrailingZeroBits())
        if (mask == 0 && diameter != 0)
            ans[diameter - 1]++
    }
    return ans
}