package cn_solution

fun maximumValueSum(nums: IntArray, k: Int, edges: Array<IntArray>): Long {
    val n = edges.size + 1
    val g = Array(n) { ArrayList<Int>() }
    for ((u, v) in edges) {
        g[u].add(v)
        g[v].add(u)
    }
    fun dfs(u: Int, p: Int): LongArray {
        var a = nums[u] + 0L
        var b = Long.MIN_VALUE / 2
        val d = nums[u].xor(k) - nums[u]
        for (v in g[u]) {
            if (v == p)
                continue
            val sub = dfs(v, u)
            val x = maxOf(a + sub[0], b - d + sub[1])
            val y = maxOf(b + sub[0], a + d + sub[1])
            a = x
            b = y
        }
        return longArrayOf(maxOf(a, b), maxOf(a + d, b - d))
    }
    return dfs(0, -1)[0]
}