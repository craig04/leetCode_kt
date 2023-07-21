package cn_offer

fun exist(board: Array<CharArray>, word: String): Boolean {
    val n = board.size - 1
    val m = board[0].size - 1
    val visit = Array(n + 1) { BooleanArray(m + 1) }
    fun dfs(i: Int, j: Int, k: Int): Boolean {
        if (visit[i][j] || board[i][j] != word[k])
            return false
        if (k == word.lastIndex)
            return true
        visit[i][j] = true
        val result = (i != 0 && dfs(i - 1, j, k + 1))
                || (i != n && dfs(i + 1, j, k + 1))
                || (j != 0 && dfs(i, j - 1, k + 1))
                || (j != m && dfs(i, j + 1, k + 1))
        visit[i][j] = false
        return result
    }
    return (0..n).any { i -> (0..m).any { j -> dfs(i, j, 0) } }
}