package cn_solution

fun countValidSubsets(parent: IntArray, nums: IntArray, k: Int): Int {
    val modulo = 1000000007
    val n = parent.size
    val g = Array(n) { ArrayList<Int>() }
    for (i in 1 until n)
        g[parent[i]].add(i)
    fun dfs(u: Int): Array<LongArray> {
        val a = LongArray(k)
        val b = LongArray(k)
        a[nums[u] % k] = 1
        b[0] = 1
        for (v in g[u]) {
            val (c, d) = dfs(v)
            val p = LongArray(k)
            val q = LongArray(k)
            for (x in 0 until k)
                for (y in 0 until k) {
                    val z = (x + y) % k
                    p[z] = (p[z] + a[x] * d[y]) % modulo
                    q[z] = (q[z] + b[x] * (c[y] + d[y])) % modulo
                }
            for (i in 0 until k) {
                a[i] = (a[i] + p[i]) % modulo
                b[i] = (b[i] + q[i]) % modulo
            }
        }
        b[0] = (b[0] + modulo - 1) % modulo
        return arrayOf(a, b)
    }
    val (a, b) = dfs(0)
    return (a[0] + b[0]).mod(modulo)
}