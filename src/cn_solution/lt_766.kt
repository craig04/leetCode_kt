package cn_solution

fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
    return (1 until matrix.size).all { i ->
        (1 until matrix.first().size).all { j ->
            val k = minOf(i, j)
            matrix[i][j] == matrix[i - k][j - k]
        }
    }
}