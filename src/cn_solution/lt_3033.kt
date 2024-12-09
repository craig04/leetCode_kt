package cn_solution

fun modifiedMatrix(matrix: Array<IntArray>): Array<IntArray> {
    for (j in matrix[0].indices) {
        var max = -1
        for (i in matrix.indices)
            max = maxOf(max, matrix[i][j])
        for (i in matrix.indices)
            if (matrix[i][j] == -1)
                matrix[i][j] = max
    }
    return matrix
}