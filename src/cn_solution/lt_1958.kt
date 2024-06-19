package cn_solution

fun checkMove(board: Array<CharArray>, rMove: Int, cMove: Int, color: Char): Boolean {
    val dir = intArrayOf(-1, -1, -1, 0, -1, 1, 0, -1, 0, 1, 1, -1, 1, 0, 1, 1)
    val row = board.indices
    val col = board.first().indices
    for (t in dir.indices step 2) {
        val dx = dir[t]
        val dy = dir[t + 1]
        var x = rMove + dx
        var y = cMove + dy
        var dist = 1
        while (x in row && y in col) {
            val c = board[x][y]
            if (c == color || c == '.')
                break
            x += dx
            y += dy
            dist++
        }
        if (x in row && y in col && dist >= 2 && board[x][y] == color)
            return true
    }
    return false
}