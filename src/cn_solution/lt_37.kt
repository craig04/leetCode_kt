package cn_solution

fun solveSudoku(board: Array<CharArray>): Unit {
    val row = IntArray(9)
    val col = IntArray(9)
    val blk = IntArray(9)
    val space = ArrayList<IntArray>()
    for (i in 0 until 9)
        for (j in 0 until 9) {
            val k = i / 3 * 3 + j / 3
            if (board[i][j] == '.') {
                space.add(intArrayOf(i, j, k))
            } else {
                val b = 1.shl(board[i][j] - '1')
                row[i] = b or row[i]
                col[j] = b or col[j]
                blk[k] = b or blk[k]
            }
        }
    fun dfs(t: Int): Boolean {
        if (t == space.size)
            return true
        val (i, j, k) = space[t]
        for (n in 0 until 9) {
            val b = 1 shl n
            if (row[i].or(col[j]).or(blk[k]).and(b) != 0)
                continue
            row[i] = b or row[i]
            col[j] = b or col[j]
            blk[k] = b or blk[k]
            board[i][j] = '1' + n
            if (dfs(t + 1))
                return true
            board[i][j] = '.'
            blk[k] = b xor blk[k]
            col[j] = b xor col[j]
            row[i] = b xor row[i]
        }
        return false
    }
    dfs(0)
}