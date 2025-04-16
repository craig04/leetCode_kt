package cn_solution

fun countCells(grid: Array<CharArray>, pattern: String): Int {
    val n = grid.size
    val m = grid[0].size
    val k = pattern.length
    fun CharArray.solve(): BooleanArray {
        val res = BooleanArray(n * m)
        var far = 0
        val len = IntArray(size)
        var l = 0
        var r = 0
        for (i in 1 until size) {
            if (i <= r)
                len[i] = minOf(len[i - l], r - i + 1)
            while (i + len[i] < size && this[i + len[i]] == this[len[i]])
                len[i]++
            if (i + len[i] - 1 > r) {
                l = i
                r = i + len[i] - 1
            }
            if (len[i] == k) {
                val j = i - k - 1
                res.fill(true, maxOf(j, far), j + k)
                far = j + k
            }
        }
        println(res.asList())
        return res
    }

    val c = pattern.toCharArray(CharArray(n * m + k + 1))
    c[k] = '#'
    for (i in 0 until n)
        for (j in 0 until m)
            c[i * m + j + k + 1] = grid[i][j]
    val row = c.solve()
    for (j in 0 until m)
        for (i in 0 until n)
            c[i + j * n + k + 1] = grid[i][j]
    val col = c.solve()
    var ans = 0
    for (i in 0 until n)
        for (j in 0 until m)
            if (row[i * m + j] && col[i + j * n])
                ans++
    return ans
}