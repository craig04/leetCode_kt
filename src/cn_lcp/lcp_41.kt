package cn_lcp

fun flipChess(chessboard: Array<String>): Int {
    val rows = chessboard.indices
    val cols = chessboard.first().indices
    val dx = intArrayOf(-1, -1, -1, 0, 0, 1, 1, 1)
    val dy = intArrayOf(-1, 0, 1, -1, 1, -1, 0, 1)
    fun flip(i: Int, j: Int): Int {
        if (chessboard[i][j] != '.')
            return 0
        val b = Array(chessboard.size) { chessboard[it].toCharArray() }
        b[i][j] = 'X'
        var count = 0
        val q = ArrayDeque<Int>()
        q.add(i.shl(4) + j)
        while (q.isNotEmpty()) {
            count++
            val pos = q.removeFirst()
            val u = pos shr 4
            val v = pos and 15
            for (t in dx.indices) {
                var x = u
                var y = v
                do {
                    x += dx[t]
                    y += dy[t]
                } while (x in rows && y in cols && b[x][y] == 'O')
                if (x !in rows || y !in cols || b[x][y] != 'X')
                    continue
                x -= dx[t]
                y -= dy[t]
                while (x != u || y != v) {
                    q.add(x.shl(4) + y)
                    b[x][y] = 'X'
                    x -= dx[t]
                    y -= dy[t]
                }
            }
        }
        return count
    }

    var res = 0
    rows.forEach { i -> cols.forEach { j -> res = maxOf(res, flip(i, j)) } }
    return res
}