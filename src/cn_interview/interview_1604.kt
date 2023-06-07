package cn_interview

fun tictactoe(board: Array<String>): String {
    val n = board.size
    fun judge(i: Int, j: Int, x: Int, y: Int): Char? {
        val init = board[i][j]
        if (init == ' ')
            return null
        var a = i
        var b = j
        return (if ((1 until n).all {
                a += x
                b += y
                board[a][b] == init
            }) init else null)
    }
    for (i in 0 until n) {
        judge(i, 0, 0, 1)?.let { return "$it" }
        judge(0, i, 1, 0)?.let { return "$it" }
    }
    judge(0, 0, 1, 1)?.let { return "$it" }
    judge(0, n - 1, 1, -1)?.let { return "$it" }
    return if (board.any { line -> line.any { it == ' ' } }) "Pending" else "Draw"
}