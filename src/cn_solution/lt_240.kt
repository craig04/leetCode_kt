package cn_solution

private fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    var r = 0
    var c = matrix[0].lastIndex
    while (r < matrix.size && c >= 0) {
        val v = matrix[r][c]
        when {
            v > target -> c--
            v < target -> r++
            else -> return true
        }
    }
    return false
}