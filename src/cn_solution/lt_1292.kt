package cn_solution

fun maxSideLength(mat: Array<IntArray>, threshold: Int): Int {
    val n = mat.size
    val m = mat[0].size
    val pre = Array(n + 1) { IntArray(m + 1) }
    for (i in 0 until n)
        for (j in 0 until m)
            pre[i + 1][j + 1] = pre[i + 1][j] + pre[i][j + 1] - pre[i][j] + mat[i][j]
    var ans = 0
    for (i in 0 until n)
        for (j in 0 until m)
            for (s in ans + 1..minOf(n - i, m - j))
                if (pre[i + s][j + s] - pre[i][j + s] - pre[i + s][j] + pre[i][j] <= threshold)
                    ans = s
    return ans
}