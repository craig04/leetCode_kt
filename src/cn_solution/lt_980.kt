package cn_solution

import kotlin.math.sign

fun uniquePathsIII(grid: Array<IntArray>): Int {
    val dp = HashMap<Int, Int>()
    val n = grid.size
    val m = grid[0].size
    var stats = 0
    var entry = listOf(0, 0)
    val delta = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    fun index(x: Int, y: Int) = x * m + y
    for (i in 0 until n)
        for (j in 0 until m) {
            if (grid[i][j] == 1)
                entry = listOf(i, j)
            if (grid[i][j] in 0..1)
                stats = 1.shl(index(i, j)).or(stats)
        }
    fun dfs(x: Int, y: Int): Int {
        if (grid[x][y] == 2)
            return 1 - stats.sign
        val pos = index(x, y)
        val key = pos.shl(n * m).or(stats)
        return dp.getOrPut(key) {
            var result = 0
            stats = 1.shl(pos).xor(stats)
            grid[x][y] -= 3
            for (t in delta.indices step 2) {
                val p = x + delta[t]
                val q = y + delta[t + 1]
                if (p in 0 until n && q in 0 until m && grid[p][q] >= 0)
                    result += dfs(p, q)
            }
            grid[x][y] += 3
            stats = 1.shl(pos).or(stats)
            result
        }
    }
    return dfs(entry[0], entry[1])
}

/**
 * Simple dfs method but actually runs faster
 */
@Suppress("FunctionName")
fun uniquePathsIII_dfs(grid: Array<IntArray>): Int {
    val n = grid.size - 1
    val m = grid[0].size - 1
    var result = 0
    var moves = grid.sumBy { line -> line.count { it == 0 } } + 1
    fun dfs(x: Int, y: Int) {
        if (grid[x][y] < 0)
            return
        if (grid[x][y] == 2) {
            if (moves == 0)
                result++
            return
        }
        grid[x][y] -= 3
        moves--
        if (x > 0) dfs(x - 1, y)
        if (x < n) dfs(x + 1, y)
        if (y > 0) dfs(x, y - 1)
        if (y < m) dfs(x, y + 1)
        moves++
        grid[x][y] += 3
    }
    loop@ for (x in grid.indices)
        for (y in grid[0].indices)
            if (grid[x][y] == 1) {
                dfs(x, y)
                break@loop
            }
    return result
}