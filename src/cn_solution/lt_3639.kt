package cn_solution

fun minTime(s: String, order: IntArray, k: Int): Int {
    val n = s.length
    var cnt = n * (n + 1L) / 2
    if (cnt < k)
        return -1
    val prev = IntArray(n + 2) { it - 1 }
    val next = IntArray(n + 2) { it + 1 }
    for (i in order.indices.reversed()) {
        val curr = order[i] + 1
        val l = prev[curr]
        val r = next[curr]
        cnt -= (curr - l) * 1L * (r - curr)
        if (cnt < k)
            return i
        next[l] = r
        prev[r] = l
    }
    return -1
}