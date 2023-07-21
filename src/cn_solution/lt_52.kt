package cn_solution

fun totalNQueens(n: Int): Int {
    fun dfs(row: Int, col: Int, left: Int, right: Int): Int {
        return if (row == n)
            1
        else (0 until n).sumOf {
            val c = 1 shl it or col
            val l = 1 shl (row + it) or left
            val r = 1 shl (row - it + n - 1) or right
            if (col != c && left != l && right != r) {
                dfs(row + 1, c, l, r)
            } else 0
        }
    }
    return dfs(0, 0, 0, 0)
}