package cn_solution

class NumMatrix(matrix: Array<IntArray>) {

    private val prefix = Array(matrix.size + 1) { IntArray(matrix[0].size + 1) }.also {
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                it[i + 1][j + 1] = it[i + 1][j] + it[i][j + 1] - it[i][j] + matrix[i][j]
            }
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        return prefix[row2 + 1][col2 + 1] - prefix[row2 + 1][col1] - prefix[row1][col2 + 1] + prefix[row1][col1]
    }
}