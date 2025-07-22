package cn_solution

fun minimumScore(nums: IntArray, edges: Array<IntArray>): Int {
    val n = nums.size
    val g = Array(n) { ArrayList<Int>() }
    for ((u, v) in edges) {
        g[u].add(v)
        g[v].add(u)
    }
    val t = IntArray(n)
    val x = IntArray(n)
    val y = IntArray(n)
    var clock = 0
    fun dfs(u: Int, p: Int): Int {
        t[u] = nums[u]
        x[u] = clock++
        for (v in g[u])
            if (v != p)
                t[u] = t[u] xor dfs(v, u)
        y[u] = clock++
        return t[u]
    }
    dfs(0, -1)
    var ans = Int.MAX_VALUE
    var (a, b, c) = intArrayOf(0, 0, 0)
    for (i in 1 until n)
        for (j in i + 1 until n) {
            if (x[i] < x[j] && y[i] > y[j]) {
                a = t[0] xor t[i]
                b = t[i] xor t[j]
                c = t[j]
            } else if (x[i] > x[j] && y[i] < y[j]) {
                a = t[0] xor t[j]
                b = t[j] xor t[i]
                c = t[i]
            } else {
                a = t[0] xor t[i] xor t[j]
                b = t[i]
                c = t[j]
            }
            ans = minOf(ans, maxOf(a, b, c) - minOf(a, b, c))
        }
    return ans
}