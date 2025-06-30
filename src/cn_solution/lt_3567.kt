package cn_solution

fun minAbsDiff(grid: Array<IntArray>, k: Int): Array<IntArray> {
    val n = grid.size + 1 - k
    val m = grid[0].size + 1 - k
    val a = IntArray(k * k)
    val ans = Array(n) { IntArray(m) { Int.MAX_VALUE } }
    for (i in 0 until n)
        for (j in 0 until m) {
            for (x in 0 until k)
                for (y in 0 until k)
                    a[x * k + y] = grid[i + x][j + y]
            a.sort()
            for (t in 0 until a.lastIndex)
                if (a[t + 1] != a[t])
                    ans[i][j] = minOf(ans[i][j], a[t + 1] - a[t])
        }
    for (i in 0 until n)
        for (j in 0 until m)
            if (ans[i][j] == Int.MAX_VALUE)
                ans[i][j] = 0
    return ans
}