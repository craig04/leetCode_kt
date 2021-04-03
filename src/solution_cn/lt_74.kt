package solution_cn

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    val n = matrix.size
    val m = matrix[0].size
    var left = 0
    var right = n * m - 1
    while (left <= right) {
        val mid = (left + right) shr 1
        val num = matrix[mid / n][mid % m]
        when {
            num < target -> left = mid + 1
            num > target -> right = mid - 1
            else -> return true
        }
    }
    return false
}