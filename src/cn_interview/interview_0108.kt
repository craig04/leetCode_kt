package cn_interview

fun setZeroes(matrix: Array<IntArray>): Unit {
    val n = matrix.size
    val m = matrix[0].size
    val row = matrix[0].any { it == 0 }
    val col = matrix.any { it[0] == 0 }
    for (i in 1 until n)
        for (j in 1 until m)
            if (matrix[i][j] == 0) {
                matrix[i][0] = 0
                matrix[0][j] = 0
            }
    for (i in 1 until n)
        for (j in 1 until m)
            if (matrix[i][0] == 0 || matrix[0][j] == 0)
                matrix[i][j] = 0
    if (col)
        for (i in 0 until n)
            matrix[i][0] = 0
    if (row)
        for (j in 0 until m)
            matrix[0][j] = 0
}
