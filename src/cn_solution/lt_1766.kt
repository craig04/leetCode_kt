package cn_solution

fun getCoprimes(nums: IntArray, edges: Array<IntArray>): IntArray {
    val n = nums.size
    val adj = Array(n) { ArrayList<Int>() }
    edges.forEach { (u, v) ->
        adj[u].add(v)
        adj[v].add(u)
    }
    fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    val map = Array(51) { i ->
        (1..50).filterTo(ArrayList()) { j -> gcd(i, j) == 1 }
    }
    val result = IntArray(n)
    val depth = IntArray(n)
    val stack = Array(51) { ArrayList<Int>() }
    fun dfs(u: Int, p: Int, d: Int) {
        result[u] = -1
        depth[u] = d
        val num = nums[u]
        for (t in map[num]) {
            if (stack[t].isEmpty())
                continue
            if (result[u] == -1 || depth[result[u]] < depth[stack[t].last()])
                result[u] = stack[t].last()
        }
        stack[num].add(u)
        for (v in adj[u])
            if (v != p)
                dfs(v, u, d + 1)
        stack[num].removeLast()
    }
    dfs(0, -1, 0)
    return result
}