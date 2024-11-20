package cn_lcp

fun numWays(n: Int, relation: Array<IntArray>, k: Int): Int {
    var pre = IntArray(n)
    var cur = IntArray(n)
    pre[0] = 1
    repeat(k) {
        cur.fill(0)
        for ((u, v) in relation)
            cur[v] += pre[u]
        val tmp = pre
        pre = cur
        cur = tmp
    }
    return pre[n - 1]
}