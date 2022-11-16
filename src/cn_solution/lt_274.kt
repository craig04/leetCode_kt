package cn_solution

private fun hIndex(citations: IntArray): Int {
    val n = citations.size
    val c = IntArray(n + 2)
    citations.forEach { c[minOf(it, n)]++ }
    var m = n
    return (1..n + 1).first {
        m -= c[it - 1]
        m < it
    }
}