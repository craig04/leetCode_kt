package cn_solution

fun cyclicShift(n: Int, grid: Array<IntArray>, rowShift: IntArray, colShift: IntArray): Array<IntArray> {
    val ans = Array(n) { IntArray(n) }
    for (i in 0 until n)
        for (j in 0 until n) {
            val x = (i + colShift[j]) % n
            val y = (j + rowShift[x]) % n
            ans[i][j] = grid[x][y]
        }
    return ans
}