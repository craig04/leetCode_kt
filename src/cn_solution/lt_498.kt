package cn_solution

fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
    val n = mat.size
    val m = mat[0].size
    var pos = 0
    val ans = IntArray(n * m)
    for (t in 0 until n + m - 1) {
        val min = maxOf(0, t - m + 1)
        val max = minOf(t, n - 1)
        val range = if (t % 2 != 0) min..max else max downTo min
        for (i in range)
            ans[pos++] = mat[i][t - i]
    }
    return ans
}