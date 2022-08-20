package cn_solution

fun movesToChessboard(board: Array<IntArray>): Int {
    val n = board.size
    val allMask = 1.shl(n) - 1
    fun getRowMask(r: Int) = (0 until n).fold(0) { m, c -> board[r][c].shl(c).xor(m) }
    fun getColMask(c: Int) = (0 until n).fold(0) { m, r -> board[r][c].shl(r).xor(m) }
    val rowMask = getRowMask(0)
    val colMask = getColMask(0)
    var sameRows = 1
    var sameCols = 1
    for (i in 1 until n) {
        when (getRowMask(i)) {
            rowMask -> sameRows++
            allMask xor rowMask -> Unit
            else -> return -1
        }
        when (getColMask(i)) {
            colMask -> sameCols++
            allMask xor colMask -> Unit
            else -> return -1
        }
    }
    fun getMoves(mask: Int, sameCount: Int): Int {
        if (n and 1 == 0) {
            if (sameCount != n / 2) return -1
            return minOf(
                Integer.bitCount(allMask and 0xAAAAAAAA.toInt() xor mask),
                Integer.bitCount(allMask and 0x55555555 xor mask)
            )
        }
        if (sameCount !in (n / 2..n / 2 + 1)) return -1
        val temp = if (mask.and(1).xor(sameCount - n / 2) == 0) 0x55555555 else 0xAAAAAAAA.toInt()
        return Integer.bitCount(allMask and temp xor mask)
    }

    val rowMoves = getMoves(colMask, sameRows)
    if (rowMoves == -1) return -1
    val colMoves = getMoves(rowMask, sameCols)
    return if (colMoves == -1) -1 else (rowMoves + colMoves) / 2
}