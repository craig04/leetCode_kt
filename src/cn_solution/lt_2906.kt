package cn_solution

fun constructProductMatrix(grid: Array<IntArray>): Array<IntArray> {
    val modulo = 12345
    val n = grid.size
    val m = grid.first().size
    val suf = Array(n) { LongArray(m) }
    var tmp = 1L
    for (i in n - 1 downTo 0)
        for (j in m - 1 downTo 0) {
            suf[i][j] = tmp
            tmp = tmp * grid[i][j] % modulo
        }
    val ans = Array(n) { IntArray(m) }
    tmp = 1L
    for (i in 0 until n)
        for (j in 0 until m) {
            ans[i][j] = (tmp * suf[i][j]).mod(modulo)
            tmp = tmp * grid[i][j] % modulo
        }
    return ans
}