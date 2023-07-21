package cn_offer

fun findNumberIn2DArray(matrix: Array<IntArray>, target: Int): Boolean {
    var i = 0
    var j = matrix.firstOrNull()?.lastIndex ?: -1
    while (i < matrix.size && j >= 0) {
        when {
            matrix[i][j] < target -> i++
            matrix[i][j] > target -> j--
            else -> return true
        }
    }
    return false
}