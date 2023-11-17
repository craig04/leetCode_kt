package cn_solution

fun possibleToStamp(grid: Array<IntArray>, stampHeight: Int, stampWidth: Int): Boolean {
    val n = grid.size
    val m = grid[0].size
    val rows = grid.indices
    val cols = grid[0].indices
    val pref = Array(n + 1) { IntArray(m + 1) }
    for (i in rows)
        for (j in cols)
            pref[i + 1][j + 1] = pref[i + 1][j] + pref[i][j + 1] - pref[i][j] + grid[i][j]
    val diff = Array(n + 2) { IntArray(m + 2) }
    for (i in 0..n - stampHeight)
        for (j in 0..m - stampWidth) {
            val x = i + stampHeight
            val y = j + stampWidth
            if (pref[x][y] - pref[x][j] - pref[i][y] + pref[i][j] == 0) {
                diff[i + 1][j + 1]++
                diff[x + 1][j + 1]--
                diff[i + 1][y + 1]--
                diff[x + 1][y + 1]++
            }
        }
    return rows.all { i ->
        cols.all { j ->
            diff[i + 1][j + 1] += diff[i + 1][j] + diff[i][j + 1] - diff[i][j]
            diff[i + 1][j + 1] or grid[i][j] != 0
        }
    }
}