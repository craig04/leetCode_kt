package cn_solution

private fun zigZagArrays(n: Int, l: Int, r: Int): Int {
    val mod = 1000000007
    val len = r - l + 1
    val size = len shl 1
    val mat = Array(size) { LongArray(size) }
    for (i in 0 until len) {
        for (j in 0 until i)
            mat[i][j + len] = 1
        for (j in i + 1 until len)
            mat[i + len][j] = 1
    }
    val ans = Array(size) { longArrayOf(1L) }
    val tmp = Array(size) { LongArray(size) }
    fun times(a: Array<LongArray>, b: Array<LongArray>) {
        tmp.forEach { it.fill(0) }
        for (i in a.indices)
            for (k in a[i].indices)
                if (a[i][k] != 0L)
                    for (j in b[k].indices)
                        tmp[i][j] += a[i][k] * b[k][j] % mod
        for (i in a.indices)
            for (j in b[0].indices)
                b[i][j] = tmp[i][j] % mod
    }

    var t = n - 1
    while (t != 0) {
        if (t % 2 == 1)
            times(mat, ans)
        times(mat, mat)
        t /= 2
    }
    return ans.sumOf { it[0] }.mod(mod)
}