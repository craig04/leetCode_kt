package cn_solution

private const val MOD = 1000000007

fun distinctSequences(n: Int): Int {
    if (n == 1)
        return 6
    fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    val adj = (1 until 36).filter { gcd(it / 6 + 1, it % 6 + 1) == 1 }.toIntArray()
    val next = Array(adj.size) { i ->
        adj.indices.filter { j ->
            adj[i] % 6 == adj[j] / 6 && adj[i] / 6 != adj[j] % 6
        }.toIntArray()
    }
    var pre = IntArray(adj.size) { 1 }
    var cur = IntArray(adj.size)
    for (t in 3..n) {
        cur.fill(0)
        for (x in adj.indices)
            for (i in next[x])
                cur[i] = (cur[i] + pre[x]) % MOD
        val tmp = pre
        pre = cur
        cur = tmp
    }
    return pre.fold(0) { ans, t -> (ans + t) % MOD }
}