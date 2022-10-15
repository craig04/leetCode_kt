package cn_solution

fun solve(board: Array<CharArray>): Unit {
    val n = board.size - 1
    val m = board[0].size - 1
    fun dfs(i: Int, j: Int) {
        if (board[i][j] == 'O') {
            board[i][j] = ' '
            if (i != 0) dfs(i - 1, j)
            if (i != n) dfs(i + 1, j)
            if (j != 0) dfs(i, j - 1)
            if (j != m) dfs(i, j + 1)
        }
    }
    for (i in 0..n) {
        dfs(i, 0)
        dfs(i, m)
    }
    for (j in 0..m) {
        dfs(0, j)
        dfs(n, j)
    }
    for (i in 0..n)
        for (j in 0..m)
            when (board[i][j]) {
                ' ' -> board[i][j] = 'O'
                'O' -> board[i][j] = 'X'
            }
}
