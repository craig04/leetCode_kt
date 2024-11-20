package cn_solution

fun countCombinations(pieces: Array<String>, positions: Array<IntArray>): Int {
    val straight = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val diagonal = intArrayOf(-1, -1, -1, 1, 1, -1, 1, 1)
    val direction = hashMapOf(
        "rook" to straight,
        "bishop" to diagonal,
        "queen" to straight + diagonal
    )
    val vis = BooleanArray(512)
    fun dfs(p: Int): Int {
        if (p == pieces.size)
            return 1
        var ans = 0
        val dir = direction[pieces[p]]!!
        val u = positions[p][0] - 1
        val v = positions[p][1] - 1
        for (i in dir.indices step 2) {
            var (t, x, y) = intArrayOf(0, u, v)
            while (x in 0..7 && y in 0..7) {
                val pos = x.shl(6) + y.shl(3)
                if (vis[pos + t])
                    break
                vis[pos + t] = true
                if (i == 0 || t != 0) {
                    var s = t + 1
                    while (s != 8 && !vis[pos + s])
                        vis[pos + s++] = true
                    if (s == 8)
                        ans += dfs(p + 1)
                    while (--s > t)
                        vis[pos + s] = false
                }
                t++
                x += dir[i]
                y += dir[i + 1]
            }
            while (--t >= 0) {
                x -= dir[i]
                y -= dir[i + 1]
                vis[x.shl(6) + y.shl(3) + t] = false
            }
        }
        return ans
    }
    return dfs(0)
}