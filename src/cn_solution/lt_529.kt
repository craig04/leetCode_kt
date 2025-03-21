package cn_solution

fun updateBoard(board: Array<CharArray>, click: IntArray): Array<CharArray> {
    val dir = intArrayOf(-1, -1, -1, 0, -1, 1, 0, -1, 0, 1, 1, -1, 1, 0, 1, 1)
    val row = board.indices
    val col = board.first().indices
    var (x, y) = click
    if (board[x][y] == 'M') {
        board[x][y] = 'X'
    } else {
        val q = ArrayDeque<Int>()
        q.add(x shl 8 or y)
        board[x][y] = '0'
        while (q.isNotEmpty()) {
            val pos = q.removeFirst()
            x = pos shr 8
            y = pos and 0xFF
            fun iterate(f: (Int, Int, Char) -> Unit) {
                for (i in dir.indices.step(2)) {
                    val u = x + dir[i]
                    val v = y + dir[i + 1]
                    if (u in row && v in col)
                        f(u, v, board[u][v])
                }
            }
            iterate { _, _, c ->
                if (c == 'M' || c == 'X')
                    board[x][y]++
            }
            if (board[x][y] != '0')
                continue
            board[x][y] = 'B'
            iterate { u, v, c ->
                if (c == 'E') {
                    board[u][v] = '0'
                    q.add(u shl 8 or v)
                }
            }
        }
    }
    return board
}