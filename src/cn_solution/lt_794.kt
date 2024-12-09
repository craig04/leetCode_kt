package cn_solution

fun validTicTacToe(board: Array<String>): Boolean {
    var cnt = 0
    for (i in 0..2)
        for (j in 0..2)
            when (board[i][j]) {
                'X' -> cnt++
                'O' -> cnt--
            }
    if (cnt !in 0..1)
        return false
    var x = 0
    var o = 0
    fun win(c: Char) {
        when (c) {
            'X' -> x++
            'O' -> o++
        }
    }
    for (i in 0..2) {
        if (board[i].all { it == board[i][0] })
            win(board[i][0])
        if (board.all { it[i] == board[0][i] })
            win(board[0][i])
    }
    if ((0..2).all { board[it][it] == board[0][0] })
        win(board[0][0])
    if ((0..2).all { board[it][2 - it] == board[0][2] })
        win(board[0][2])
    return (cnt == 0 && x == 0) || (cnt > 0 && o == 0)
}