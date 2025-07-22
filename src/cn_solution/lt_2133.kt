package cn_solution

fun checkValid(matrix: Array<IntArray>): Boolean {
    val n = matrix.size
    val row = IntArray(n)
    val col = IntArray(n)
    for (i in 0 until n)
        for (j in 0 until n)
            if (row[matrix[i][j] - 1]++ != i || col[matrix[j][i] - 1]++ != j)
                return false
    return true
}