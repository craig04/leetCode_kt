package cn_solution

fun numRookCaptures(board: Array<CharArray>): Int {
    val d = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val row = board.indices
    val col = board[0].indices
    var x = 0
    var y = 0
    loop@ for (i in row)
        for (j in col)
            if (board[i][j] == 'R') {
                x = i
                y = j
                break@loop
            }
    return d.indices.step(2).count { i ->
        var u = x + d[i]
        var v = y + d[i + 1]
        while (u in row && v in col) {
            if (board[u][v] != '.')
                return@count board[u][v] == 'p'
            u += d[i]
            v += d[i + 1]
        }
        false
    }
}