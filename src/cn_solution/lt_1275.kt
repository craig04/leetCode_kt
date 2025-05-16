package cn_solution

fun tictactoe(moves: Array<IntArray>): String {
    val win = hashSetOf(7, 56, 448, 73, 146, 292, 273, 84)
    val put = IntArray(2)
    for (i in moves.indices) {
        val player = i and 1
        val idx = moves[i][0] * 3 + moves[i][1]
        put[player] = put[player] or (1 shl idx)
        if (win.any { it and put[player] == it })
            return if (player == 0) "A" else "B"
    }
    return if (moves.size == 9) "Draw" else "Pending"
}