package cn_solution

fun countLocalMaximums(matrix: Array<IntArray>): Int {
    val n = matrix.size
    val m = matrix.first().size
    val r = 33 - (n - 1).countLeadingZeroBits()
    val c = 33 - (m - 1).countLeadingZeroBits()
    val st = Array(r) { Array(c) { Array(n) { IntArray(m) } } }
    for (i in 0 until n)
        for (j in 0 until m)
            st[0][0][i][j] = matrix[i][j]
    for (y in 1 until c) {
        val w = 1.shl(y - 1)
        for (i in 0 until n)
            for (j in 0 until m - w)
                st[0][y][i][j] = maxOf(st[0][y - 1][i][j], st[0][y - 1][i][j + w])
    }
    for (x in 1 until r) {
        val h = 1.shl(x - 1)
        for (y in 0 until c)
            for (i in 0 until n - h)
                for (j in 0 until m)
                    st[x][y][i][j] = maxOf(st[x - 1][y][i][j], st[x - 1][y][i + h][j])
    }
    fun query(r1: Int, c1: Int, r2: Int, c2: Int): Int {
        val t = maxOf(0, r1)
        val l = maxOf(0, c1)
        val b = minOf(n, r2)
        val r = minOf(m, c2)
        val h = 31 - (b - t).countLeadingZeroBits()
        val w = 31 - (r - l).countLeadingZeroBits()
        return maxOf(
            st[h][w][t][l],
            st[h][w][b - 1.shl(h)][l],
            st[h][w][t][r - 1.shl(w)],
            st[h][w][b - 1.shl(h)][r - 1.shl(w)]
        )
    }

    var ans = 0
    for (i in 0 until n)
        for (j in 0 until m) {
            val x = matrix[i][j]
            if (x == 0)
                continue
            val max1 = query(i - x + 1, j - x, i + x, j + x + 1)
            val max2 = query(i - x, j - x + 1, i + x + 1, j + x)
            if (x == maxOf(max1, max2))
                ans++
        }
    return ans
}