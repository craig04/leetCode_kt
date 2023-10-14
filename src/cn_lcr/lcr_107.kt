package cn_lcr

fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
    val n = mat.size
    val m = mat[0].size
    val r = n - 1
    val c = m - 1
    val dist = Array(n) { IntArray(m) { Int.MAX_VALUE.shr(2) } }
    for (i in 0 until n)
        for (j in 0 until m)
            if (mat[i][j] == 0)
                dist[i][j] = 0
    fun update(i: Int, j: Int, x: Int, y: Int) {
        dist[i][j] = minOf(dist[i][j], dist[x][y] + 1)
    }
    for (i in 0 until n)
        for (j in 0 until m) {
            if (i != 0) update(i, j, i - 1, j)
            if (j != 0) update(i, j, i, j - 1)
        }
    for (i in r downTo 0)
        for (j in c downTo 0) {
            if (i != r) update(i, j, i + 1, j)
            if (j != c) update(i, j, i, j + 1)
        }
    return dist
}