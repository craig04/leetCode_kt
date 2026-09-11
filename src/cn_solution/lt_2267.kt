package cn_solution

fun hasValidPath(grid: Array<CharArray>): Boolean {
    val n = grid.size
    val m = grid[0].size
    if (n xor m and 1 == 0 || grid[0][0] == ')' || grid[n - 1][m - 1] == '(')
        return false
    val max = (n + m - 1) / 2
    val tmp = BooleanArray(max + 1)
    val cur = Array(m + 1) { BooleanArray(max + 1) }
    cur[1][0] = true
    for (i in 0 until n)
        for (j in 0 until m) {
            cur[j + 1].copyInto(tmp)
            val d = if (grid[i][j] == '(') 1 else -1
            val p = minOf(max, n + m - i - j - 2)
            for (k in 0..p)
                cur[j + 1][k] = k - d in 0..max && (cur[j][k - d] || tmp[k - d])
            cur[j + 1].fill(false, p + 1)
        }
    return cur[m][0]
}