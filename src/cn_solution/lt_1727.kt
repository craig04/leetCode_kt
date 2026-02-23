package cn_solution

fun largestSubmatrix(matrix: Array<IntArray>): Int {
    val m = matrix.first().size
    val h = IntArray(m)
    val t = IntArray(m)
    var ans = 0
    for (row in matrix) {
        for (j in 0 until m)
            h[j] = if (row[j] == 0) 0 else h[j] + 1
        h.copyInto(t)
        t.sort()
        for (j in 0 until m)
            ans = maxOf(ans, t[j] * (m - j))
    }
    return ans
}