package cn_solution

class Solution_1728 {

    companion object {
        const val DRAW = -1
        const val MOUSE = 0
        const val CAT = 1
    }

    fun canMouseWin(grid: Array<String>, catJump: Int, mouseJump: Int): Boolean {
        val dir = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
        val n = grid.size
        val m = grid[0].length
        val rows = grid.indices
        val cols = grid[0].indices
        val total = n * m
        val degree = Array(total) { Array(total) { IntArray(2) } }
        val result = Array(total) { Array(total) { IntArray(2) { DRAW } } }
        var a = -1
        var b = -1
        var c = -1
        val g = Array(total) { ArrayList<Int>() }
        val h = Array(total) { ArrayList<Int>() }
        for (i in 0 until n)
            for (j in 0 until m) {
                val pos = i * m + j
                when (grid[i][j]) {
                    '#' -> continue
                    'M' -> a = pos
                    'C' -> b = pos
                    'F' -> c = pos
                }
                for (k in dir.indices.step(2)) {
                    var (x, y) = intArrayOf(i, j)
                    for (t in 0..mouseJump) {
                        g[pos].add(x * m + y)
                        x += dir[k]
                        y += dir[k + 1]
                        if (x !in rows || y !in cols || grid[x][y] == '#')
                            break
                    }
                    var (u, v) = intArrayOf(i, j)
                    for (t in 0..catJump) {
                        h[pos].add(u * m + v)
                        u += dir[k]
                        v += dir[k + 1]
                        if (u !in rows || v !in cols || grid[u][v] == '#')
                            break
                    }
                }
            }
        for (x in 0 until total) {
            if (grid[x / m][x % m] == '#')
                continue
            for (y in 0 until total) {
                if (grid[y / m][y % m] == '#')
                    continue
                degree[x][y][MOUSE] = g[x].size
                degree[x][y][CAT] = h[y].size
            }
        }
        val q = ArrayDeque<IntArray>()
        for (x in 0 until total) {
            if (grid[x / m][x % m] == '#')
                continue
            if (x != c) {
                result[x][c][MOUSE] = CAT
                result[c][x][CAT] = MOUSE
                q.addLast(intArrayOf(x, c, MOUSE))
                q.addLast(intArrayOf(c, x, CAT))
            }
            result[x][x][MOUSE] = CAT
            result[x][x][CAT] = CAT
            q.addLast(intArrayOf(x, x, MOUSE))
            q.addLast(intArrayOf(x, x, CAT))
        }
        while (q.isNotEmpty()) {
            val (x, y, z) = q.removeFirst()
            val res = result[x][y][z]
            val prev = when (z) {
                MOUSE -> h[y].map { intArrayOf(x, it, CAT) }
                else -> g[x].map { intArrayOf(it, y, MOUSE) }
            }
            for ((u, v, w) in prev) {
                if (result[u][v][w] == DRAW) {
                    if (res == w) {
                        result[u][v][w] = w
                        q.add(intArrayOf(u, v, w))
                    } else if (--degree[u][v][w] == 0) {
                        result[u][v][w] = w xor 1
                        q.add(intArrayOf(u, v, w))
                    }
                }
            }
        }
        return result[a][b][MOUSE] == MOUSE
    }
}