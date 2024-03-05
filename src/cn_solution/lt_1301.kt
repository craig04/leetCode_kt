package cn_solution

fun pathsWithMaxScore(board: List<String>): IntArray {
    val modulo = 1000000007
    val n = board.size
    val m = board[0].length
    val s = Array(n + 1) { IntArray(m + 1) }
    val c = Array(n + 1) { IntArray(m + 1) }
    s[n][m] = 0
    c[n][m] = 1
    for (i in n - 1 downTo 0) {
        for (j in m - 1 downTo 0) {
            s[i][j] = 0
            c[i][j] = 0
            if (board[i][j] == 'X')
                continue
            val k = if (board[i][j].isDigit()) board[i][j] - '0' else 0
            fun update(x: Int, y: Int) {
                if (c[x][y] == 0 || s[x][y] + k < s[i][j])
                    return
                if (s[x][y] + k > s[i][j]) {
                    s[i][j] = s[x][y] + k
                    c[i][j] = 0
                }
                c[i][j] = (c[i][j] + c[x][y]) % modulo
            }
            update(i + 1, j)
            update(i, j + 1)
            update(i + 1, j + 1)
        }
    }
    return intArrayOf(s[0][0], c[0][0])
}