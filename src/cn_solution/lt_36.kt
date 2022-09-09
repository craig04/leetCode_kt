package cn_solution

fun isValidSudoku(board: Array<CharArray>): Boolean {
    val row = Array(9) { IntArray(9) }
    val col = Array(9) { IntArray(9) }
    val box = Array(3) { Array(3) { IntArray(9) } }
    return (0 until 81).all {
        val i = it / 9
        val j = it % 9
        board[i][j] == '.' || (board[i][j] - '1').let { k ->
            ++row[i][k] < 2 && ++col[j][k] < 2 && ++box[i / 3][j / 3][k] < 2
        }
    }
}
