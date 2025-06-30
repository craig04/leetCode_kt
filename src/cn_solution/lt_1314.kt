package cn_solution

fun matrixBlockSum(mat: Array<IntArray>, k: Int): Array<IntArray> {
    val n = mat.size
    val m = mat[0].size
    val a = Array(n + 1) { IntArray(m + 1) }
    for (i in 1..n)
        for (j in 1..m)
            a[i][j] = a[i - 1][j] + a[i][j - 1] - a[i - 1][j - 1] + mat[i - 1][j - 1]
    return Array(n) { i ->
        IntArray(m) { j ->
            val l = maxOf(0, i - k)
            val r = minOf(n, i + k + 1)
            val u = maxOf(0, j - k)
            val d = minOf(m, j + k + 1)
            a[r][d] - a[l][d] - a[r][u] + a[l][u]
        }
    }
}