package cn_solution

fun gameOfLife(board: Array<IntArray>): Unit {
    val rows = board.indices
    val cols = board[0].indices
    for (i in rows)
        for (j in cols) {
            var live = 0
            for (x in i - 1..i + 1)
                for (y in j - 1..j + 1)
                    if (x in rows && y in cols)
                        live += board[x][y] and 1
            if (live == 3 || (board[i][j] == 1 && live == 4))
                board[i][j] = board[i][j] or 2
        }
    for (i in rows)
        for (j in cols)
            board[i][j] = board[i][j] shr 1
}